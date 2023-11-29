@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("mingki.android.library")
}

android {
    namespace = "com.mingki.core.ui"

}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.constraintlayout)
}