package dev.rendrap.app.movienight

import com.android.build.api.dsl.CommonExtension
import dev.rendrap.app.movienight.ext.androidTestImplementation
import dev.rendrap.app.movienight.ext.debugImplementation
import dev.rendrap.app.movienight.ext.implementation
import dev.rendrap.app.movienight.ext.library
import dev.rendrap.app.movienight.ext.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary("androidx.compose.bom").get()
            implementation(platform(bom))
            androidTestImplementation(platform(bom))
            implementation(libs.library("androidx.compose.ui.tooling.preview"))
            debugImplementation(libs.library("androidx.compose.ui.tooling"))
        }

        @Suppress("UnstableApiUsage")
        testOptions {
            unitTests {
                isIncludeAndroidResources = true
            }
        }
    }
}