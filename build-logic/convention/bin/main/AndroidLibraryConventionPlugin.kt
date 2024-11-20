import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import dev.rendrap.app.movienight.config.BuildConfig.TARGET_SDK
import dev.rendrap.app.movienight.configureFlavors
import dev.rendrap.app.movienight.configureJacoco
import dev.rendrap.app.movienight.configureKotlinAndroid
import dev.rendrap.app.movienight.ext.implementation
import dev.rendrap.app.movienight.ext.library
import dev.rendrap.app.movienight.ext.libs
import dev.rendrap.app.movienight.ext.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
            apply("jacoco")
        }

        extensions.getByType<LibraryExtension>().buildTypes.configureEach {
            enableAndroidTestCoverage = true
            enableUnitTestCoverage = true
        }

        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)
            configureFlavors(this)

            @Suppress("UnstableApiUsage")
            testOptions {
                animationsDisabled = true
                targetSdk = TARGET_SDK

                unitTests.all {
                    it.useJUnitPlatform()
                }
            }
        }

        configureJacoco(extensions.getByType<LibraryAndroidComponentsExtension>())

        dependencies {
            implementation(libs.library("log4k"))
            implementation(platform(libs.findLibrary("arrow.bom").get()))
            implementation(libs.library("arrow.core"))
            implementation(libs.library("arrow.fx.coroutines"))
            implementation(libs.library("quiver"))

            testImplementation(libs.library("kotest.runner.junit5"))
            testImplementation(libs.library("kotest.assertions.core"))
            testImplementation(libs.library("mockk"))
            testImplementation(libs.library("turbine"))
        }
    }
}