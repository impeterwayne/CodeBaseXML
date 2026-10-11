import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.ksp)
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.ui"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxAppcompat)
    api(libs.material)
    api(libs.androidxConstraintlayout)
    implementation(libs.androidxActivity)
    api(libs.androidxFragmentKtx)
    implementation(libs.androidxLifecycleViewmodelKtx)
    implementation(libs.androidxLifecycleRuntimeKtx)
    implementation(libs.immersionbar)

    api(libs.shapeView)
    implementation(libs.lottie)
    api(libs.epoxy)
    ksp(libs.epoxyProcessor)
}
