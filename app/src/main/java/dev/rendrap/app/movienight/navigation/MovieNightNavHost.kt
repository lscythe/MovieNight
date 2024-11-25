package dev.rendrap.app.movienight.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import dev.rendrap.app.movienight.feature.home.navigation.HomeNavGraph
import dev.rendrap.app.movienight.feature.home.navigation.homeNavGraph
import dev.rendrap.app.movienight.ui.MovieNightAppState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MovieNightNavHost(
    appState: MovieNightAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    val navManager = appState.navigationManager

    LaunchedEffect(Unit) {
        navManager.commands.collectLatest { command ->
            when (command) {
                NavigationCommand.NavigateBack -> navController.popBackStack()
                NavigationCommand.NavigateUp -> navController.navigateUp()
                NavigationCommand.NavigateHome -> appState.navigateToTopLevelDestination(
                    TopLevelDestination.DISCOVER
                )
                is NavigationCommand.NavigateTo -> navController.navigate(command.destination) {
                    command.navOptions?.let { options ->
                        launchSingleTop = options.shouldLaunchSingleTop()
                        popUpTo(options.popUpToRouteClass ?: false) {
                            inclusive = options.isPopUpToInclusive()
                        }
                    }
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = HomeNavGraph,
        modifier = modifier
    ) {
        homeNavGraph(onShowSnackbar)
    }
}