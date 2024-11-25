import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.feature.get().pluginId)
}

android {
    namespace = namespace("feature.home")
}

dependencies {
    implementation(projects.domain.tmdb)
}