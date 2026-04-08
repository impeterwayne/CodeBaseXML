import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
    id("codebase.android.hilt")
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.ksp)
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.database"

    defaultConfig {
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {
    implementation(project(":core:model"))

    // Room
    implementation(libs.androidxRoomRuntime)
    ksp(libs.androidxRoomCompiler)
    implementation(libs.androidxRoomKtx)

    // Moshi (for type converters)
    implementation(libs.moshi)
    implementation(libs.moshiKotlin)

    // Coroutines
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinxCoroutinesAndroid)
}
