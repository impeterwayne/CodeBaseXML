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
    // Core modules
    implementation(project(":core:common"))

    // AndroidX
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxAppcompat)
    api(libs.material)
    api(libs.androidxConstraintlayout)

    // SDP / SSP
    implementation(libs.sdpAndroid)
    implementation(libs.sspAndroid)

    // ShapeView
    implementation(libs.shapeView)

    // Lottie
    implementation(libs.lottie)

    // Epoxy
    api(libs.epoxy)
    kapt(libs.epoxyProcessor)
}
