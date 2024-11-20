import dev.rendrap.app.movienight.config.BuildConfig.namespace

plugins {
    id(libs.plugins.movienight.android.library.asProvider().get().pluginId)
    id(libs.plugins.movienight.hilt.get().pluginId)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.plugin.serialization)
}

android {
    namespace = namespace("network")

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.common)

    api(libs.bundles.ktor)

    implementation(platform(libs.okhttp.bom))
    api(libs.okhttp)
    api(libs.okhttp.logging.interceptor)

    implementation(libs.coil)

    implementation(libs.kotlinx.serialization.json)

    debugApi(libs.chucker)
    releaseApi(libs.chucker.noop)

    implementation(libs.androidx.paging.runtime)
}