package dev.rendrap.app.movienight.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.rendrap.app.movienight.feature.home.screen.discover.DiscoverScreen
import dev.rendrap.app.movienight.model.MovieSortBy
import dev.rendrap.app.movienight.model.TVSortBy
import kotlinx.serialization.Serializable

@Serializable
data object HomeNavGraph

sealed interface HomeRoute {
    @Serializable
    data object Discover : HomeRoute

    @Serializable
    data object Search : HomeRoute

    @Serializable
    data object Favorites : HomeRoute

    @Serializable
    data object Settings : HomeRoute
}

interface HomeNavigation {
    fun navigateToMoviesDetail(type: MovieSortBy)
    fun navigateToTVsDetail(type: TVSortBy)
    fun navigateToMovieDetail(id: Long)
    fun navigateToTVDetail(id: Long)
}

fun NavController.navigateToHome(
    destination: HomeRoute = HomeRoute.Discover,
    navOptions: NavOptions
) = navigate(route = destination, navOptions = navOptions)

fun NavGraphBuilder.homeNavGraph(
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    navigation<HomeNavGraph>(startDestination = HomeRoute.Discover) {
        composable<HomeRoute.Discover> { DiscoverScreen() }
        composable<HomeRoute.Search> { }
        composable<HomeRoute.Favorites> { }
        composable<HomeRoute.Settings> { }
    }
}