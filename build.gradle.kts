plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.ksp) apply false
}

tasks.register("clean", Delete::class) {
    delete(layout.buildDirectory)
    delete("build-logic/convention/build")
}

subprojects {
    afterEvaluate {
        if (tasks.findByName("clean") == null) {
            tasks.register("clean", Delete::class) {
                delete(layout.buildDirectory)
            }
        }
    }
}
