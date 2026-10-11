import com.android.build.api.variant.BuildConfigField
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
}

androidComponents {
    onVariants { variant ->
        variant.buildConfigFields?.put(
            "BASE_URL",
            BuildConfigField(
                type = "String",
                value = "\"https://ai-service.backendvn.com/\"",
                comment = "Backend API base URL"
            )
        )
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
    implementation(libs.converterGson)
    implementation(libs.gson)

    // Sandwich
    implementation(libs.sandwich)
    implementation(libs.sandwichRetrofit)
}
