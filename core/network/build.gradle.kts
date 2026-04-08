import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
    id("codebase.android.hilt")
    alias(libs.plugins.ksp)
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.network"

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"https://ai-service.backendvn.com/\"")
    }
}

dependencies {
    implementation(project(":core:model"))

    // OkHttp
    implementation(platform(libs.okhttpBom))
    implementation(libs.okhttp)
    implementation(libs.loggingInterceptor)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit2KotlinCoroutinesAdapter)
    implementation(libs.converterMoshi)

    // Sandwich
    implementation(libs.sandwich)
    implementation(libs.sandwichRetrofit)

    // Moshi
    ksp(libs.moshiKotlinCodegen)
    implementation(libs.moshi)
    implementation(libs.moshiKotlin)
    implementation(libs.moshiAdapters)
}
