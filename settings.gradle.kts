pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Music App"
include(":app")
include(":feature")
include(":feature:home")
include(":feature:around")
include(":feature:stereo")
include(":feature:search")
include(":feature:storage")
