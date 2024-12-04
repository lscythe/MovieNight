package dev.rendrap.app.movienight.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.rendrap.app.movienight.feature.detail.navigation.DetailRoute
import dev.rendrap.app.movienight.feature.home.navigation.HomeNavGraph
import dev.rendrap.app.movienight.feature.player.navigation.PlayerRoute
import dev.rendrap.app.movienight.feature.player.screen.PlayerScreen
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.navigation.navgraph.detailNavGraph
import dev.rendrap.app.movienight.navigation.navgraph.homeNavGraph

@Composable
fun MVNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeNavGraph,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        homeNavGraph(
            onShowSnackbar = onShowSnackbar,
            onMediaClick = { id, type ->
                val destination = when (type) {
                    MediaType.TV_SERIES -> DetailRoute.TvShow(id)
                    MediaType.MOVIES -> DetailRoute.Movie(id)
                }
                navHostController.navigate(destination) {

                }
            },
            onShowMoreMovieClick = {},
            onShowMoreTVClick = {},
        )
        detailNavGraph(
            onShowSnackbar,
            onBackClick = {
                navHostController.popBackStack()
            },
            onPlayClick = {
                navHostController.navigate(PlayerRoute.Player(it))
            }
        )
        composable<PlayerRoute.Player> { backStackEntry ->
            val args: PlayerRoute.Player = backStackEntry.toRoute()
            PlayerScreen(url = args.url)
        }
    }
}