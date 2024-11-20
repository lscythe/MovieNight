import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    // Workaround for https://github.com/gradle/gradle/issues/29652
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
}

android {
    namespace = namespace("common")
}