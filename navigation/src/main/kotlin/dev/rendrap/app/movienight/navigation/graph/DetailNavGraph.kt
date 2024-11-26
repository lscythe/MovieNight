package dev.rendrap.app.movienight.navigation.graph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import dev.rendrap.app.movienight.core.common.extension.pairOf
import dev.rendrap.app.movienight.core.common.utils.Constants.ZERO_LONG
import dev.rendrap.app.movienight.feature.detail.navigation.DetailNavGraph
import dev.rendrap.app.movienight.feature.detail.navigation.DetailRoute
import dev.rendrap.app.movienight.feature.detail.screen.media.MediaScreen
import dev.rendrap.app.movienight.model.MediaType

fun NavGraphBuilder.detailNavGraph(
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onBackClick: () -> Unit,
    onPlayClick: (String) -> Unit,
) {
    navigation<DetailNavGraph>(startDestination = DetailRoute.Movie(ZERO_LONG)) {
        composable<DetailRoute.Movie>(
            enterTransition = { fadeIn() + slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up) },
            exitTransition = { fadeOut() + slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Down) },
            popEnterTransition = { fadeIn() + slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up) },
            popExitTransition = { fadeOut() + slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Down) }
        ) { backStackEntry ->
            val args: DetailRoute.Movie = backStackEntry.toRoute()
            MediaScreen(
                media = pairOf(args.id, MediaType.MOVIES),
                onBackClick = onBackClick,
                onPlayClick = onPlayClick
            )
        }
        composable<DetailRoute.TvShow>(
            enterTransition = { fadeIn() + slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up) },
            exitTransition = { fadeOut() + slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Down) },
            popEnterTransition = { fadeIn() + slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up) },
            popExitTransition = { fadeOut() + slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Down) }
        ) { backStackEntry ->
            val args: DetailRoute.TvShow = backStackEntry.toRoute()
            MediaScreen(
                media = pairOf(args.id, MediaType.TV_SERIES),
                onBackClick = onBackClick,
                onPlayClick = onPlayClick
            )
        }
        composable<DetailRoute.List> { }
        composable<DetailRoute.People> { }
        composable<DetailRoute.CrewAndCast> { }
    }
}