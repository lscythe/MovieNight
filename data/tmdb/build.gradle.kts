import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
    alias(libs.plugins.secrets)
    alias(libs.plugins.kotlin.plugin.serialization)
}

android {
    namespace = namespace("data.tmdb")

    buildFeatures {
        buildConfig = true
    }
}

secrets {
    defaultPropertiesFileName = "secrets.properties"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.network)
    implementation(projects.domain.tmdb)
    implementation(projects.model)

    implementation(libs.androidx.paging.runtime)
    implementation(libs.kotlinx.serialization.json)
}