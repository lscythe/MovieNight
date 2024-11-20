import com.android.build.api.dsl.LibraryExtension
import dev.rendrap.app.movienight.config.BuildConfig.INSTRUMENT_RUNNER
import dev.rendrap.app.movienight.ext.implementation
import dev.rendrap.app.movienight.ext.library
import dev.rendrap.app.movienight.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply {
            apply("assignment.android.library")
            apply("assignment.android.library.compose")
            apply("assignment.hilt")
            apply("org.jetbrains.kotlin.plugin.serialization")
        }

        extensions.configure<LibraryExtension> {
            defaultConfig.testInstrumentationRunner = INSTRUMENT_RUNNER
        }

        dependencies {
            implementation(project(":core:designsystem"))
            implementation(project(":core:ui"))

            implementation(libs.library("androidx.hilt.navigation.compose"))
            implementation(libs.library("androidx.navigation.compose"))
            implementation(libs.library("androidx.lifecycle.runtime.compose"))
            implementation(libs.library("androidx.lifecycle.viewmodel.compose"))

            implementation(libs.library("kotlinx.serialization.json"))
        }
    }
}