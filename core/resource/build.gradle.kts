import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.android.library.compose.get().pluginId)
    alias(libs.plugins.ksp)
}

android {
    namespace = namespace("resource")
}

ksp {
    arg("lyricist.internalVisibility", "true")
}

dependencies {
    api(libs.androidx.compose.material.icon.extended)
    api(libs.composeicons.octicons)

    implementation(libs.lyricist)
    ksp(libs.lyricist.processor)
}