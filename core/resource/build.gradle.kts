import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.android.library.compose.get().pluginId)
    alias(libs.plugins.ksp)
}

android {
    namespace = namespace("core.resource")
}

ksp {
    arg("lyricist.packageName", "dev.rendrap.app.movienight.core.resource")
    arg("lyricist.moduleName", "resource")
}

dependencies {
    implementation(projects.core.common)

    api(libs.androidx.compose.material.icon.extended)
    api(libs.composeicons.octicons)

    implementation(libs.lyricist)
    ksp(libs.lyricist.processor)
}