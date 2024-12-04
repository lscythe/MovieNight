
import dev.rendrap.app.movienight.BuildTypes
import dev.rendrap.app.movienight.config.BuildConfig.APPLICATION_ID
import dev.rendrap.app.movienight.config.BuildConfig.INSTRUMENT_RUNNER

plugins {
    id(libs.plugins.movienight.android.application.asProvider().get().pluginId)
    id(libs.plugins.movienight.android.application.compose.get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
}
android {
    defaultConfig {
        applicationId = APPLICATION_ID

        testInstrumentationRunner = INSTRUMENT_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = BuildTypes.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            signingConfig = signingConfigs.named("debug").get()
        }
    }

    buildFeatures {
        buildConfig = true
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/LICENSE.md")
        }
    }

    @Suppress("UnstableApiUsage")
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = APPLICATION_ID
}


dependencies {
    implementation(projects.core.common)
    implementation(projects.core.designsystem)
    implementation(projects.core.network)
    implementation(projects.core.resource)
    implementation(projects.data.favorite)
    implementation(projects.data.setting)
    implementation(projects.data.tmdb)
    implementation(projects.domain.setting)
    implementation(projects.navigation)

    implementation(projects.feature.home)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)
}