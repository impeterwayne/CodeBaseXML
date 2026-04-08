import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kapt)
    alias(libs.plugins.kotlinParcelize)
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.codebase"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.genesys.codebase"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }

    buildTypes {
        debug {
            // BASE_URL is now in :core:network
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // ── Core modules ──
    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:common"))

    // ── Feature modules ──
    implementation(project(":feature:template"))

    // ── Android Core ──
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxAppcompat)
    implementation(libs.material)
    implementation(libs.androidxActivity)
    implementation(libs.androidxConstraintlayout)
    implementation(libs.androidxStartupRuntime)
    implementation(libs.androidxMultidex)
    implementation(libs.androidxLifecycleViewmodelKtx)
    implementation(libs.androidxFragmentKtx)

    // Hilt
    implementation(libs.hiltAndroid)
    ksp(libs.hiltCompiler)

    // MMKV (initialized in App.kt)
    implementation(libs.mmkv)

    // Timber
    implementation(libs.timber)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidxJunit)
    androidTestImplementation(libs.androidxEspressoCore)
}
