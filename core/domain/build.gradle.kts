plugins {
    id("codebase.android.library")
}

android {
    namespace = "com.genesys.core.domain"
}

dependencies {
    implementation(project(":core:model"))

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // AndroidX annotations
    implementation("androidx.core:core-ktx:1.16.0")
}
