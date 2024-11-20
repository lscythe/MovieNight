package dev.rendrap.app.movienight.ext

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun VersionCatalog.version(alias: String): String =
    this.findVersion(alias).get().toString()

internal fun VersionCatalog.bundle(alias: String): Any = this.findBundle(alias).get()

internal fun VersionCatalog.library(alias: String): Any = this.findLibrary(alias).get()

internal fun VersionCatalog.plugin(alias: String): Any = this.findPlugin(alias).get()