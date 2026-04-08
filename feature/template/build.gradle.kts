import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.feature")
    alias(libs.plugins.kapt)
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.feature.template"

    buildFeatures {
        dataBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Epoxy
    implementation(libs.epoxy)
    kapt(libs.epoxyProcessor)
}
