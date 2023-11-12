import org.jetbrains.kotlin.cli.jvm.main

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("mingki.android.application")
    id("mingki.android.hilt")
    id("mingki.android.navigation")
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
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}