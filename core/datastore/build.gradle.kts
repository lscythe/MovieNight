import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
}

android {
    namespace = namespace("core.datastore")
}

dependencies {
    implementation(projects.core.common)

    api(libs.androidx.datastore.preferences)
    implementation(libs.androidx.security.crypto)
    implementation(libs.security.crypto.datastore.preferences)
}