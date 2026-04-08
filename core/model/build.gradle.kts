import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
    alias(libs.plugins.kotlinParcelize)
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.model"
}

dependencies {
    // Moshi annotations
    implementation(libs.moshi)
    implementation(libs.moshiKotlin)

    // AndroidX annotations
    implementation(libs.androidxCoreKtx)
}
