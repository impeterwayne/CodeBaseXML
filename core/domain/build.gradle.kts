import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
    id("codebase.android.hilt")
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))

    // Coroutines
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinxCoroutinesAndroid)

    // AndroidX annotations
    implementation(libs.androidxCoreKtx)
}
