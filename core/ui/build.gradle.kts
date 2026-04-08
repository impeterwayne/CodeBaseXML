import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.kapt)
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.ui"

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    // AndroidX
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxAppcompat)
    api(libs.material)
    api(libs.androidxConstraintlayout)

    // ShapeView
    api(libs.shapeView)
    // Lottie
    implementation(libs.lottie)
    // Epoxy
    api(libs.epoxy)
    kapt(libs.epoxyProcessor)
}
