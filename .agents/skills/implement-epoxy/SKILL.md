# Implement Epoxy Pattern For Android Projects

## When to Use This Skill

Use this skill when the task is to add or extend an Epoxy-based screen in an Android project.

This skill is designed to be portable across projects. It uses a proven pattern extracted from a working codebase, but the target project must adapt:
- package names
- module names
- ViewBinding class names
- layout resource names
- image loading utilities
- app architecture details
- Gradle plugin style

This skill assumes:
- Kotlin
- Android ViewBinding
- Epoxy with KSP
- screen composition through `EpoxyRecyclerView` and `withModels { ... }`

---

## Dependency Setup

Use explicit versions unless the target project already manages them differently.

### Version Catalog example

```toml
[versions]
epoxy = "5.1.4"
ksp = "2.1.0-1.0.29"

[libraries]
epoxy = { module = "com.airbnb.android:epoxy", version.ref = "epoxy" }
epoxyProcessor = { module = "com.airbnb.android:epoxy-processor", version.ref = "epoxy" }

[plugins]
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
```

### Module `build.gradle.kts` example

```kotlin
plugins {
    id("com.android.library") // or com.android.application
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.airbnb.android:epoxy:5.1.4")
    ksp("com.airbnb.android:epoxy-processor:5.1.4")
}
```

### Important notes

- Prefer `ksp` for Epoxy processor wiring
- Do not switch to `kapt` unless the target project explicitly requires it
- If the target project uses a version catalog, adapt the dependency declarations to match its style
- If the target project has shared UI modules, place common Epoxy utilities there

---

## Core Pattern

This skill follows a simple structure:

1. Put an `EpoxyRecyclerView` in XML
2. Build screen models inside `withModels { ... }`
3. Create feature-local Epoxy models with `@EpoxyModelClass`
4. Reuse a shared `BaseEpoxyViewBindingHolder`
5. Use `@EpoxyAttribute(DoNotHash)` for callbacks
6. Clear listeners in `unbind()`
7. Use a shared carousel helper if the screen needs a horizontal list without snap

---

## Step 1: Add `EpoxyRecyclerView` To Layout

Use this pattern in the screen XML:

```xml
<com.airbnb.epoxy.EpoxyRecyclerView
    android:id="@+id/rcv_templates"
    android:layout_width="0dp"
    android:layout_height="0dp"
    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

Adapt:
- `@+id/rcv_templates`
- parent constraints
- layout sizing rules

Keep:
- `com.airbnb.epoxy.EpoxyRecyclerView`
- a normal linear layout manager unless the design requires otherwise

---

## Step 2: Create A Shared Base Holder For ViewBinding Models

Use this as the shared base class for Epoxy models that bind with ViewBinding.

```kotlin
import android.view.View
import android.view.ViewParent
import androidx.viewbinding.ViewBinding
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.util.concurrent.ConcurrentHashMap

abstract class BaseEpoxyViewBindingHolder<in T : ViewBinding> : EpoxyModelWithHolder<ViewBindingHolder>() {

    @Suppress("UNCHECKED_CAST")
    override fun bind(holder: ViewBindingHolder) {
        (holder.viewBinding as T).bind()
    }

    abstract fun T.bind()

    @Suppress("UNCHECKED_CAST")
    override fun unbind(holder: ViewBindingHolder) {
        (holder.viewBinding as T).unbind()
    }

    open fun T.unbind() {}

    override fun createNewHolder(parent: ViewParent): ViewBindingHolder {
        return ViewBindingHolder(this::class.java)
    }
}

private val sBindingMethodByClass = ConcurrentHashMap<Class<*>, Method>()

@Suppress("UNCHECKED_CAST")
@Synchronized
private fun getBindMethodFrom(javaClass: Class<*>): Method =
    sBindingMethodByClass.getOrPut(javaClass) {
        val actualTypeOfThis = getSuperclassParameterizedType(javaClass)
        val viewBindingClass = actualTypeOfThis.actualTypeArguments[0] as Class<ViewBinding>
        viewBindingClass.getDeclaredMethod("bind", View::class.java)
            ?: error("The binder class ${javaClass.canonicalName} should have a method bind(View)")
    }

private fun getSuperclassParameterizedType(klass: Class<*>): ParameterizedType {
    val genericSuperclass = klass.genericSuperclass
    return (genericSuperclass as? ParameterizedType)
        ?: getSuperclassParameterizedType(genericSuperclass as Class<*>)
}

class ViewBindingHolder(private val epoxyModelClass: Class<*>) : EpoxyHolder() {
    private val bindingMethod by lazy { getBindMethodFrom(epoxyModelClass) }

    internal lateinit var viewBinding: ViewBinding

    override fun bindView(itemView: View) {
        viewBinding = bindingMethod.invoke(null, itemView) as ViewBinding
    }
}
```

Use this when:
- the project uses ViewBinding
- you want small Epoxy models without writing repetitive holder boilerplate

Adapt:
- package name only

Do not change this pattern unless the target project already has its own Epoxy base model abstraction.

---

## Step 3: Create A Simple Header Model

Use a small model like this for section headers:

```kotlin
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass

@EpoxyModelClass
abstract class TemplateCollectionHeaderModel :
    BaseEpoxyViewBindingHolder<ItemTemplateCollectionHeaderBinding>() {

    @EpoxyAttribute
    open var collectionName: String = ""

    override fun getDefaultLayout(): Int = R.layout.item_template_collection_header

    override fun ItemTemplateCollectionHeaderBinding.bind() {
        tvCollectionName.text = collectionName
    }
}
```

Adapt:
- `TemplateCollectionHeaderModel`
- `ItemTemplateCollectionHeaderBinding`
- `R.layout.item_template_collection_header`
- `tvCollectionName`
- `collectionName`

Keep:
- `@EpoxyModelClass`
- extending `BaseEpoxyViewBindingHolder`
- simple `@EpoxyAttribute` properties for render data

---

## Step 4: Create An Interactive Item Model

Use this pattern for clickable item rows:

```kotlin
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass

@EpoxyModelClass
abstract class TemplateItemModel :
    BaseEpoxyViewBindingHolder<ItemTemplateBinding>() {

    @EpoxyAttribute
    open var template: Template = Template()

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    open var onItemClick: (() -> Unit)? = null

    override fun getDefaultLayout(): Int = R.layout.item_template

    override fun ItemTemplateBinding.bind() {
        val imageUrl = BASE_URL + "content" + template.thumbnail
        imgThumbnail.loadImageWithGlide(imageUrl)
        tvTemplateName.text = template.name
        ivPremiumBadge.visibility = if (template.premium) View.VISIBLE else View.GONE
        root.setOnClickListener { onItemClick?.invoke() }
    }

    override fun ItemTemplateBinding.unbind() {
        root.setOnClickListener(null)
    }

    companion object {
        private const val BASE_URL = "https://ai-service.backendvn.com/"
    }
}
```

Adapt:
- `TemplateItemModel`
- `ItemTemplateBinding`
- `Template`
- `R.layout.item_template`
- `loadImageWithGlide(...)`
- view IDs like `imgThumbnail`, `tvTemplateName`, `ivPremiumBadge`
- URL building logic
- item fields

Keep:
- callback attributes marked with `DoNotHash`
- `unbind()` clearing listeners
- binding UI from a model object

Important:
- If the target project uses Coil, Glide, Picasso, or another image loader, replace `loadImageWithGlide(...)`
- If the target project does not want a default empty `Template()`, make the attribute nullable or use a different initialization approach

---

## Step 5: Build Models In The Fragment Or Screen Owner

Use this composition style in the Fragment:

```kotlin
private fun setupEpoxy(collections: List<TemplateCollections>) {
    viewBinding.rcvTemplates.withModels {
        collections.forEach { collection ->
            templateCollectionHeader {
                id("header_${collection.id}")
                collectionName(collection.name)
            }

            carouselNoSnapBuilder {
                id("carousel_${collection.id}")
                padding(Carousel.Padding.dp(16, 0, 16, 0, 8))

                collection.templates.forEach { template ->
                    templateItem {
                        id("template_${template.id}")
                        template(template)
                        onItemClick {
                            mainViewModel.onEvent(
                                MainViewModel.MainEvent.OnTemplateClicked(template)
                            )
                        }
                    }
                }
            }
        }
    }
}
```

Adapt:
- `TemplateCollections`
- `collection.id`
- `collection.name`
- `collection.templates`
- `templateItem`
- `templateCollectionHeader`
- click action behavior
- `mainViewModel`

Keep:
- `withModels { ... }`
- stable ids
- section-by-section composition
- generated Epoxy DSL functions such as `templateItem { ... }`

Important:
- these builder functions are generated by Epoxy from your annotated models
- do not manually create or edit generated code

---

## Step 6: Optional Shared No-Snap Carousel

If the screen needs a horizontal carousel without snap, use this shared pattern.

### Custom no-snap carousel view

```kotlin
import android.content.Context
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.ModelView.Size

@ModelView(saveViewState = true, autoLayout = Size.MATCH_WIDTH_WRAP_HEIGHT)
class CarouselNoSnap(context: Context) : Carousel(context) {
    override fun getSnapHelperFactory(): Nothing? = null
}
```

### DSL builder wrapper

```kotlin
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.ModelCollector

fun ModelCollector.carouselNoSnapBuilder(builder: EpoxyCarouselNoSnapBuilder.() -> Unit): CarouselNoSnapModel_ {
    val carouselBuilder = EpoxyCarouselNoSnapBuilder().apply { builder() }
    add(carouselBuilder.carouselNoSnapModel)
    return carouselBuilder.carouselNoSnapModel
}

class EpoxyCarouselNoSnapBuilder(
    internal val carouselNoSnapModel: CarouselNoSnapModel_ = CarouselNoSnapModel_()
) : ModelCollector, CarouselNoSnapModelBuilder by carouselNoSnapModel {
    private val models = mutableListOf<EpoxyModel<*>>()

    override fun add(model: EpoxyModel<*>) {
        models.add(model)
        carouselNoSnapModel.models(models)
    }
}
```

Use this when:
- the design needs a horizontally scrolling list
- snapping is unwanted
- the project benefits from a reusable Epoxy DSL wrapper

Adapt:
- package name
- naming if your project uses a different shared UI vocabulary

Keep:
- the `@ModelView` carousel class
- the DSL wrapper pattern
- internal `models` accumulation and `carouselNoSnapModel.models(models)`

---

## Rules For Generated Code

Epoxy will generate builder APIs from your annotations.

Examples:
- `TemplateCollectionHeaderModel` generates `templateCollectionHeader { ... }`
- `TemplateItemModel` generates `templateItem { ... }`
- `CarouselNoSnap` generates `CarouselNoSnapModel_` and its builder interfaces

Rules:
- never edit generated files
- write or change source annotations instead
- if generated builders are missing, verify KSP and the processor dependency first

---

## Adaptation Checklist For Another Project

Before applying this pattern, adapt these items:

- package names
- module names
- Gradle plugin style
- ViewBinding class names
- layout resource names
- view IDs
- item data models
- image loading implementation
- click handling behavior
- architecture calls such as ViewModel events
- whether the project wants shared UI helpers or feature-local utilities

---

## Guardrails

Do not:
- hardcode this project’s package names into another project
- copy the exact model data type if the target app has a different domain model
- keep `BASE_URL` unless the target app truly needs that pattern
- assume Glide exists in the destination project
- switch Epoxy to KAPT unless required
- edit generated Epoxy files
- skip stable ids in `withModels`

Prefer:
- project-native naming
- small feature-local models
- shared base holder utilities
- `DoNotHash` for listeners and lambdas
- clearing listeners in `unbind()`

---

## Expected Output From The Agent

When using this skill, the agent should produce:
1. Gradle changes needed for Epoxy runtime and processor
2. XML with `EpoxyRecyclerView` if needed
3. Epoxy model classes using `@EpoxyModelClass`
4. Fragment or screen composition using `withModels { ... }`
5. Shared helper code if the project does not already have it
6. A short explanation of which parts were copied as pattern and which parts were adapted for the target project
