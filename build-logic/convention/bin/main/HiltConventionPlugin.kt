import dev.rendrap.app.movienight.ext.implementation
import dev.rendrap.app.movienight.ext.ksp
import dev.rendrap.app.movienight.ext.library
import dev.rendrap.app.movienight.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply {
            apply("com.google.devtools.ksp")
            apply("dagger.hilt.android.plugin")
        }

        dependencies {
            implementation(libs.library("dagger.hilt.android"))
            ksp(libs.library("dagger.hilt.compiler"))
        }
    }
}