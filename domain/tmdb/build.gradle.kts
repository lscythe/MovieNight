import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
}

android {
    namespace = namespace("domain.jsonplaceholder")
}

dependencies {
    implementation(projects.model)
}