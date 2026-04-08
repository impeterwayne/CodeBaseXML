// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kapt) apply false
}

// Root-level clean task to delete the root project's build directory
// Also cleans build-logic (included build, not covered by subprojects)
tasks.register("clean", Delete::class) {
    delete(layout.buildDirectory)
    delete("build-logic/convention/build")
}

// Add 'clean' task to any subproject that doesn't natively have it (like parent directories :core, :feature, etc.)
subprojects {
    afterEvaluate {
        if (tasks.findByName("clean") == null) {
            tasks.register("clean", Delete::class) {
                delete(layout.buildDirectory)
            }
        }
    }
}
