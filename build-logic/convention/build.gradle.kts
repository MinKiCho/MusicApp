@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
}

group = "com.mingki.musicapp"


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
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

        register("androidLibrary") {
            id = "mingki.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidFeature") {
            id = "mingki.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidHilt") {
            id = "mingki.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidNavigation") {
            id = "mingki.android.navigation"
            implementationClass = "AndroidNavigationConventionPlugin"
        }

        register("jvmLibrary") {
            id = "mingki.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}