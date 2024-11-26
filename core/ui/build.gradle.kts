import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.android.library.compose.get().pluginId)
}

android {
    namespace = namespace("core.ui")
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.model)

    implementation(libs.coil)
    implementation(libs.coil.compose)
}