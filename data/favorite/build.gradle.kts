import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
}

android {
    namespace = namespace("data.favorite")
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.domain.favorite)
    implementation(projects.model)

    implementation(libs.kotlinx.datetime)
}