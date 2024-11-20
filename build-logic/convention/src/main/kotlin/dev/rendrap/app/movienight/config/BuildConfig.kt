package dev.rendrap.app.movienight.config

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object BuildConfig {
    const val TARGET_SDK = 34
    const val COMPILE_SDK = 34
    const val MIN_SDK = 24

    val JAVA_VERSION = JavaVersion.VERSION_17
    val JVM_TARGET = JvmTarget.JVM_17

    const val APPLICATION_ID = "dev.rendrap.app.movienight"
    const val INSTRUMENT_RUNNER = "$APPLICATION_ID.test.runner.AndroidJUnitRunner"

    fun namespace(module: String) = "$APPLICATION_ID.$module"
}