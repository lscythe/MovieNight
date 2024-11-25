package dev.rendrap.app.movienight.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import dev.rendrap.app.movienight.core.resource.icons.MVIcon
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Archive
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Cog
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Movie
import dev.rendrap.app.movienight.core.resource.icons.mvicon.SearchAlt
import dev.rendrap.app.movienight.feature.home.navigation.HomeRoute
import kotlin.reflect.KClass

enum class TopLevelDestination(
    val icon: ImageVector,
    val route: KClass<*>,
) {
    DISCOVER(
        icon = MVIcon.Movie,
        route = HomeRoute.Discover::class
    ),
    SEARCH(
        icon = MVIcon.SearchAlt,
        route = HomeRoute.Search::class
    ),
    FAVORITE(
        icon = MVIcon.Archive,
        route = HomeRoute.Favorites::class
    ),
    SETTINGS(
        icon = MVIcon.Cog,
        route = HomeRoute.Settings::class
    )
}