pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "MovieNight"
include(":app")

include(
    listOf(
        ":core:common",
        ":core:database",
        ":core:datastore",
        ":core:designsystem",
        ":core:network",
        ":core:resource",
        ":core:ui"
    )
)
include(":model", ":navigation")
include(
    listOf(
        ":data:favorite",
        ":data:setting",
        ":data:tmdb",
    )
)
include(
    listOf(
        ":domain:favorite",
        ":domain:setting",
        ":domain:tmdb",
    )
)
include(
    ":feature:home",
    ":feature:detail",
    ":feature:player",
)
 