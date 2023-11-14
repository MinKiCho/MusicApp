import com.android.build.gradle.LibraryExtension
import com.mingki.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("mingki.android.library")
                apply("mingki.android.hilt")
                apply("mingki.android.navigation")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
                }
            }

            dependencies {
                add("implementation", project(":core:model"))
                add("implementation", project(":core:ui"))

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))

                add("implementation", libs.findLibrary("androidx.navigation.fragment").get())
                add("implementation", libs.findLibrary("androidx.navigation.ui").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModel.ktx").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}