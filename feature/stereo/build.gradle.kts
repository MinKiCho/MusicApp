@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("mingki.android.feature")
}

android {
    namespace = "com.mingki.stereo"

}

dependencies {
    implementation(libs.appcompat)
}