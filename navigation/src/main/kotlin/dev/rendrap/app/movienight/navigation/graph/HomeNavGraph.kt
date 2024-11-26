package dev.rendrap.app.movienight.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.rendrap.app.movienight.feature.home.navigation.HomeNavGraph
import dev.rendrap.app.movienight.feature.home.navigation.HomeRoute
import dev.rendrap.app.movienight.feature.home.screen.discover.DiscoverScreen
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.MovieSortBy
import dev.rendrap.app.movienight.model.TVSortBy

fun NavGraphBuilder.homeNavGraph(
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onShowMoreMovieClick: (type: MovieSortBy) -> Unit,
    onShowMoreTVClick: (type: TVSortBy) -> Unit,
    onMediaClick: (id: Long, type: MediaType) -> Unit,
) {
    navigation<HomeNavGraph>(startDestination = HomeRoute.Discover) {
        composable<HomeRoute.Discover> {
            DiscoverScreen(
                onShowMoreTVClick = onShowMoreTVClick,
                onShowMoreMovieClick = onShowMoreMovieClick,
                onMediaClick = onMediaClick
            )
        }
        composable<HomeRoute.Search> { }
        composable<HomeRoute.Favorites> { }
        composable<HomeRoute.Settings> { }
    }
}