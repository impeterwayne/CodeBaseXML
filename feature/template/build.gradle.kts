import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.implementation
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.feature")
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.feature.template"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Epoxy
    implementation(project(":core:ui"))
    implementation(libs.epoxy)
    ksp(libs.epoxyProcessor)
}
