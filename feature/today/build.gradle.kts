@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("mingki.android.feature")
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.mingki.today"
}

dependencies {
    implementation(libs.appcompat)
}