package dev.rendrap.app.movienight.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import dev.rendrap.app.movienight.core.common.utils.NetworkMonitor
import dev.rendrap.app.movienight.feature.home.navigation.HomeRoute
import dev.rendrap.app.movienight.feature.home.navigation.navigateToHome
import dev.rendrap.app.movienight.navigation.NavigationManager
import dev.rendrap.app.movienight.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberMovieNightAppState(
    networkMonitor: NetworkMonitor,
    navigationManager: NavigationManager,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
) = remember(
    networkMonitor,
    coroutineScope,
    navController,
    navigationManager
) {
    MovieNightAppState(
        navController,
        navigationManager,
        coroutineScope,
        networkMonitor,
    )
}

@Stable
class MovieNightAppState(
    val navController: NavHostController,
    val navigationManager: NavigationManager,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = TopLevelDestination.entries.firstOrNull { topLevelDestination ->
            currentDestination?.hasRoute(route = topLevelDestination.route) == true
        }

    val isOffline = networkMonitor.isConnected
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(destination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (destination) {
            TopLevelDestination.DISCOVER -> navController.navigateToHome(
                destination = HomeRoute.Discover,
                navOptions = topLevelNavOptions
            )

            TopLevelDestination.SEARCH -> navController.navigateToHome(
                destination = HomeRoute.Search,
                navOptions = topLevelNavOptions
            )

            TopLevelDestination.FAVORITE -> navController.navigateToHome(
                destination = HomeRoute.Favorites,
                navOptions = topLevelNavOptions
            )

            TopLevelDestination.SETTINGS -> navController.navigateToHome(
                destination = HomeRoute.Settings,
                navOptions = topLevelNavOptions
            )
        }
    }
}