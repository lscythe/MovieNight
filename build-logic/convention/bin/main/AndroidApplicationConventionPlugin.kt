import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.rendrap.app.movienight.config.BuildConfig.TARGET_SDK
import dev.rendrap.app.movienight.configureFlavors
import dev.rendrap.app.movienight.configureJacoco
import dev.rendrap.app.movienight.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
            apply("jacoco")
        }

        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)
            defaultConfig.targetSdk = TARGET_SDK
            configureFlavors(this)

            @Suppress("UnstableApiUsage")
            testOptions {
                animationsDisabled = true
            }
        }

        extensions.getByType<BaseAppModuleExtension>().buildTypes.configureEach {
            enableAndroidTestCoverage = true
            enableUnitTestCoverage = true
        }

        configureJacoco(extensions.getByType<ApplicationAndroidComponentsExtension>())
    }
}