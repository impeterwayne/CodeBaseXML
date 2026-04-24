# Build Logic Map

This file is a contributor map for how Gradle is wired in this repo today. It focuses on the files and rules that actually control module inclusion, convention plugins, shared defaults, and dependency flow.

## 1. Root build wiring

The root `settings.gradle.kts` does two key jobs:

* It brings the included build at `build-logic` into plugin resolution with `pluginManagement { includeBuild("build-logic") }`.
* It includes the app and feature/core modules that make up the main project:
  * `:app`
  * `:core:model`
  * `:core:network`
  * `:core:database`
  * `:core:domain`
  * `:core:data`
  * `:core:ui`
  * `:core:common`
  * `:feature:template`

The same file also sets the shared artifact repositories for project dependencies. Project repositories are locked with `RepositoriesMode.FAIL_ON_PROJECT_REPOS`, so module builds are expected to use the root repository setup.

The root `build.gradle.kts` is intentionally thin:

* It declares plugin aliases at the top level with `apply false`.
* It does not apply shared Android or Kotlin behavior itself.
* It registers a root `clean` task that deletes both the root build output and `build-logic/convention/build`.
* It also adds a `clean` task to subprojects that do not already have one.

That means most reusable build behavior lives in `build-logic`, not in the root build script.

## 2. How `build-logic` is wired

`build-logic` is a separate included build.

`build-logic/settings.gradle.kts`:

* imports `../gradle/libs.versions.toml` into a `libs` version catalog
* includes the `:convention` module

`build-logic/convention/build.gradle.kts`:

* uses `kotlin-dsl`
* builds the convention code itself with Java 17 and Kotlin JVM target 17
* depends on the Android Gradle Plugin, Kotlin Gradle Plugin, and KSP Gradle Plugin through the shared `libs` catalog
* publishes four convention plugin IDs:
  * `codebase.android.library`
  * `codebase.android.feature`
  * `codebase.android.hilt`
  * `codebase.jvm.library`

Inside convention source, `ProjectExtensions.kt` exposes `Project.libs`, which is the version catalog accessor for convention code.

## 3. Version and dependency truth

`gradle/libs.versions.toml` is the main catalog for:

* library versions used by modules
* plugin versions used by module build scripts
* plugin dependency coordinates used by `build-logic/convention/build.gradle.kts`

It is not the only effective source of dependency truth.

Some convention plugins hard code coordinates and versions directly in Kotlin source. Right now that includes:

* `AndroidLibraryConventionPlugin.kt`
  * `com.jakewharton.timber:timber:5.0.1`
* `AndroidHiltConventionPlugin.kt`
  * `com.google.dagger:hilt-android:2.53`
  * `com.google.dagger:hilt-compiler:2.53`
* `AndroidFeatureConventionPlugin.kt`
  * `androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1`
  * `org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3`

So when a dependency version changes, the update might belong in `libs.versions.toml`, in convention source, or in both.

## 4. Convention plugins and what they inject

### `codebase.android.library`

Implemented by `build-logic/convention/src/main/kotlin/AndroidLibraryConventionPlugin.kt`.

This plugin applies:

* `com.android.library`
* `org.jetbrains.kotlin.android`

It also sets shared Android and Kotlin defaults for consumer modules:

* `compileSdk = 36`
* `minSdk = 24`
* `consumerProguardFiles("consumer-rules.pro")`
* Java source and target compatibility 11
* Kotlin JVM target 11 through `configureKotlinJvm()`

It also injects Timber directly:

* `implementation("com.jakewharton.timber:timber:5.0.1")`

### `codebase.android.hilt`

Implemented by `build-logic/convention/src/main/kotlin/AndroidHiltConventionPlugin.kt`.

This plugin applies:

* `com.google.dagger.hilt.android`
* `com.google.devtools.ksp`

It also injects:

* `implementation("com.google.dagger:hilt-android:2.53")`
* `ksp("com.google.dagger:hilt-compiler:2.53")`

If `kotlin-kapt` is also present, the plugin removes duplicate Hilt compiler entries from kapt configurations after evaluation. That keeps Hilt on the KSP path even in modules that still use kapt for other processors.

### `codebase.android.feature`

Implemented by `build-logic/convention/src/main/kotlin/AndroidFeatureConventionPlugin.kt`.

This plugin applies:

* `codebase.android.library`
* `codebase.android.hilt`

It also injects project dependencies on:

* `:core:ui`
* `:core:model`
* `:core:domain`
* `:core:common`

And it adds two external dependencies directly:

* `androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1`
* `org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3`

### `codebase.jvm.library`

Implemented by `build-logic/convention/src/main/kotlin/JvmLibraryConventionPlugin.kt`.

This plugin applies `org.jetbrains.kotlin.jvm`, sets the Java toolchain to 11, and uses `KotlinJvm.kt` to set Kotlin JVM target 11 plus `-opt-in=kotlin.RequiresOptIn`.

At the moment, no checked module in this repo applies `codebase.jvm.library`.

## 5. Java and Kotlin target split

There are two different target levels in play:

* `build-logic/convention/build.gradle.kts` builds the convention plugin code with Java 17 and Kotlin JVM target 17.
* Consumer modules configured through `AndroidLibraryConventionPlugin.kt`, `JvmLibraryConventionPlugin.kt`, and `KotlinJvm.kt` target Java 11 and Kotlin JVM 11.
* `app/build.gradle.kts` also sets Java 11 and Kotlin JVM target 11 directly.

That split is not inherently wrong, but it means toolchain changes are a two place job. Updating consumer target levels does not automatically update the build-logic toolchain, and the reverse is also true.

## 6. Module to plugin map

Here is the current plugin layout by module.

### `:app`

`app` does not use the repo convention plugins. It applies plugin aliases directly:

* `androidApplication`
* `kotlinAndroid`
* `hiltAndroid`
* `ksp`
* `kapt`
* `kotlinParcelize`

This makes `app` an intentional exception to the convention based setup used by library modules.

### `:core:common`

Applies:

* `codebase.android.library`
* `kapt` via alias

From the convention point of view this is an Android library module, but it also adds a local `kapt` override.

### `:core:data`

Applies:

* `codebase.android.library`
* `codebase.android.hilt`

### `:core:domain`

Applies:

* `codebase.android.library`
* `codebase.android.hilt`

### `:core:network`

Applies:

* `codebase.android.library`
* `codebase.android.hilt`
* `ksp` via alias

The explicit `ksp` alias here is for module specific KSP work, on top of the Hilt convention also applying KSP.

### `:core:database`

Applies:

* `codebase.android.library`
* `codebase.android.hilt`
* `kotlinParcelize` via alias
* `ksp` via alias

### `:core:ui`

Applies:

* `codebase.android.library`
* `kotlinParcelize` via alias
* `kapt` via alias

### `:core:model`

Applies:

* `codebase.android.library`
* `kotlinParcelize` via alias

### `:feature:template`

Applies:

* `codebase.android.feature`
* `kapt` via alias

Because `codebase.android.feature` already applies `codebase.android.library` and `codebase.android.hilt`, this module inherits both of those convention layers automatically.

## 7. Inter module dependency map

This is the current project dependency flow from module build files plus convention injected dependencies.

```text
:app
  -> :core:model
  -> :core:network
       -> :core:model
  -> :core:database
       -> :core:model
  -> :core:domain
       -> :core:model
       -> :core:common
  -> :core:data
       -> :core:model
       -> :core:domain
       -> :core:network
       -> :core:database
       -> :core:common
  -> :core:ui
  -> :core:common
  -> :feature:template
       -> :core:ui
       -> :core:model
       -> :core:domain
       -> :core:common
```

A few practical notes about that graph:

* `:core:model` is the most reused leaf module. `:core:network`, `:core:database`, `:core:domain`, and `:core:data` all depend on it.
* `:core:data` is the main aggregation module among the core libraries. It depends on model, domain, network, database, and common.
* `:feature:template` gets most of its project dependencies from `codebase.android.feature`, not only from its own `build.gradle.kts`.
* `app` depends on every core module plus `:feature:template` directly.

## 8. Convention injected external dependency map

Some dependencies arrive because a module applies a convention plugin, not because the module declared them itself.

```text
codebase.android.library
  -> timber 5.0.1

codebase.android.hilt
  -> hilt-android 2.53
  -> hilt-compiler 2.53 on KSP

codebase.android.feature
  -> :core:ui
  -> :core:model
  -> :core:domain
  -> :core:common
  -> lifecycle-viewmodel-ktx 2.6.1
  -> coroutines-android 1.7.3
```

This is the main reason `libs.versions.toml` is only the main catalog, not the full dependency truth.

## 9. Where to change things

Use this section as the shortest path to the file that actually owns a change.

### Add or remove included modules

Edit `settings.gradle.kts`.

### Change top level plugin aliases or the root clean behavior

Edit `build.gradle.kts`.

If the change is about cleaning the included build output, check the custom delete of `build-logic/convention/build` there.

### Change the version catalog

Edit `gradle/libs.versions.toml`.

This covers most library versions, plugin versions, and the plugin dependency coordinates used by `build-logic/convention/build.gradle.kts`.

### Change how convention code reads the catalog

Edit `build-logic/convention/src/main/kotlin/ProjectExtensions.kt`.

### Add, rename, or remove convention plugin IDs

Edit `build-logic/convention/build.gradle.kts`.

### Change shared Android library defaults

Edit `build-logic/convention/src/main/kotlin/AndroidLibraryConventionPlugin.kt`.

That is where `compileSdk`, `minSdk`, Java 11, Kotlin JVM 11, consumer ProGuard, and the convention injected Timber dependency are set.

### Change shared Hilt and KSP behavior

Edit `build-logic/convention/src/main/kotlin/AndroidHiltConventionPlugin.kt`.

That is where Hilt, KSP, Hilt dependency injection, and the kapt duplicate cleanup logic live.

### Change the default feature module wiring

Edit `build-logic/convention/src/main/kotlin/AndroidFeatureConventionPlugin.kt`.

That is where feature modules inherit library plus Hilt behavior, plus default core dependencies and the extra lifecycle/coroutines dependencies.

### Change shared JVM only defaults

Edit both:

* `build-logic/convention/src/main/kotlin/JvmLibraryConventionPlugin.kt`
* `build-logic/convention/src/main/kotlin/KotlinJvm.kt`

### Change app specific build behavior

Edit `app/build.gradle.kts`.

The app module is not on the library convention path, so changing `codebase.android.library` or `codebase.android.feature` will not update app settings automatically.

## 10. Current sharp edges

These are the places most likely to surprise a contributor.

### The version catalog is not the only source of truth

Several shared dependencies are hard coded in convention plugin source. If a version looks wrong at runtime, check both `gradle/libs.versions.toml` and the Kotlin files under `build-logic/convention/src/main/kotlin/`.

### `app` is outside the convention path

`app` applies Android, Kotlin, Hilt, KSP, kapt, and parcelize directly. Shared changes in library conventions do not automatically reach the app module.

### `codebase.android.hilt` always brings in KSP

Any module that applies the Hilt convention gets KSP whether or not the module file declares `alias(libs.plugins.ksp)`. That is expected here, but it can make plugin ownership less obvious when reading a module build file in isolation.

### Some modules still add local plugin overrides

Examples in the current tree:

* `:core:common` adds `kapt` locally on top of `codebase.android.library`.
* `:core:network` and `:core:database` add explicit `ksp` aliases for their own processors.
* `:feature:template` adds `kapt` locally for Epoxy.

So the convention plugin tells only part of the story. You still need to check the module build file for local processors and overrides.

### `:feature:template` has overlapping `:core:ui` wiring

`codebase.android.feature` already injects `:core:ui`, and `feature/template/build.gradle.kts` also declares `implementation(project(":core:ui"))` directly. That overlap is harmless, but it means the dependency is declared in two places.

### Toolchain levels are split between build logic and consumers

The convention build itself uses Java/Kotlin 17, while convention consumers target Java/Kotlin 11. Any future toolchain update should check both sides together.

## 11. Quick mental model

If you want the shortest accurate mental model, it is this:

1. `settings.gradle.kts` includes both project modules and the `build-logic` included build.
2. `build-logic` defines reusable convention plugins in `:convention`.
3. Most library modules apply those convention plugin IDs, then add only module specific plugins and dependencies.
4. `app` is the main exception because it wires Android and Hilt plugins directly.
5. `libs.versions.toml` is the main catalog, but convention source still hard codes some shared dependencies.

That combination is what drives the repo today.
