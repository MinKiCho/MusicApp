import org.jetbrains.kotlin.cli.jvm.main

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("mingki.android.application")
    id("mingki.android.hilt")
}

android {
    namespace = "com.mingki.musicapp"

    defaultConfig {
        applicationId = "com.mingki.musicapp"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }



}

dependencies {

    implementation(project(":feature:home"))
    implementation(project(":feature:around"))
    implementation(project(":feature:stereo"))
    implementation(project(":feature:search"))
    implementation(project(":feature:storage"))
    implementation(project(":feature:today"))
    implementation(project(":core:ui"))
    implementation(project(":core:model"))

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)
    implementation(libs.androidx.media3.session)
    implementation(libs.androidx.media3.common)

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}