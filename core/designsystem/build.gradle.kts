import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.android.library.compose.get().pluginId)
}

android {
    namespace = namespace("designsystem")
}

dependencies {
    api(projects.core.resource)

    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.text)
    api(libs.androidx.compose.runtime)
}