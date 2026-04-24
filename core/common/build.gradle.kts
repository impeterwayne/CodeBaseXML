import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.common"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Timber
    implementation(libs.timber)

    // AndroidX
    implementation(libs.androidxCoreKtx)
    api(libs.androidxAppcompat)
    implementation(libs.material)
    implementation(libs.androidxConstraintlayout)
    implementation(libs.androidxActivity)
    api(libs.androidxFragmentKtx)
    implementation(libs.androidxLifecycleViewmodelKtx)

    // ImmersionBar
    implementation(libs.immersionbar)
    implementation(libs.immersionbarKtx)
    implementation(libs.immersionbarComponents)

    // Coroutines
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinxCoroutinesAndroid)

    // Glide (used by ImageViewExt)
    implementation(libs.glide)

    // Gson (used by GsonExt)
    implementation(libs.gson)

    // Lifecycle runtime (used by FlowExt)
    implementation(libs.androidxLifecycleRuntimeKtx)
}
