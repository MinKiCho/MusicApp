@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
//    id("java-library")
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
}

group = "com.mingki.musicapp"


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin{
    plugins{
        register("androidApplication") {
            id = "mingki.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidHilt") {
            id = "mingki.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidNavigation") {
            id = "mingki.android.navigation"
            implementationClass = "AndroidNavigationConventionPlugin"
        }
    }
}