import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

plugins {
    id("codebase.android.library")
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "com.genesys.core.common"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.timber)

    implementation(libs.androidxCoreKtx)
    api(libs.androidxAppcompat)
    implementation(libs.material)
    implementation(libs.androidxConstraintlayout)
    implementation(libs.androidxActivity)
    api(libs.androidxFragmentKtx)
    implementation(libs.androidxLifecycleViewmodelKtx)

    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinxCoroutinesAndroid)

    implementation(libs.glide)

    implementation(libs.gson)

    implementation(libs.androidxLifecycleRuntimeKtx)
}
