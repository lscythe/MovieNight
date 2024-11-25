import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
}

android {
    namespace = namespace("navigation")
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.feature.home)
    implementation(projects.model)

    implementation(libs.androidx.navigation.compose)
}