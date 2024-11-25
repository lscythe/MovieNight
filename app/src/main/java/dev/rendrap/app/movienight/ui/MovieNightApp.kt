package dev.rendrap.app.movienight.ui

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import dev.rendrap.app.movienight.core.common.extension.isNotNull
import dev.rendrap.app.movienight.core.designsystem.component.MVNavigationBar
import dev.rendrap.app.movienight.core.designsystem.component.MVNavigationBarItem
import dev.rendrap.app.movienight.core.designsystem.component.MVScaffold
import dev.rendrap.app.movienight.core.resource.LocalResourceStrings
import dev.rendrap.app.movienight.navigation.MovieNightNavHost
import dev.rendrap.app.movienight.navigation.TopLevelDestination
import kotlin.reflect.KClass

@Composable
fun MovieNightApp(
    appState: MovieNightAppState,
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val isOffline by appState.isOffline.collectAsStateWithLifecycle()
    val strings = LocalResourceStrings.current

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = strings.noInternetConnection,
                duration = SnackbarDuration.Indefinite
            )
        }
    }

    MovieNightApp(
        appState = appState,
        snackbarHostState = snackbarHostState,
        modifier = modifier,
    )
}

@Composable
internal fun MovieNightApp(
    appState: MovieNightAppState,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    val currentDestination = appState.currentDestination
    val currentTopLevelDestination = appState.currentTopLevelDestination
    val strings = LocalResourceStrings.current

    MVScaffold(
        modifier = modifier,
        showBottomNavBar = currentTopLevelDestination.isNotNull(),
        bottomNavBar = {
            MVNavigationBar {
                appState.topLevelDestinations.forEach { destination ->
                    val label = when (destination) {
                        TopLevelDestination.DISCOVER -> strings.discover
                        TopLevelDestination.SEARCH -> strings.search
                        TopLevelDestination.FAVORITE -> strings.favorite
                        TopLevelDestination.SETTINGS -> strings.setting
                    }
                    val selected = currentDestination.isRouteInHierarchy(destination.route)

                    MVNavigationBarItem(
                        selected = selected,
                        onClick = { appState.navigateToTopLevelDestination(destination) },
                        icon = destination.icon,
                        label = label,
                    )
                }
            }
        }
    ) {
        MovieNightNavHost(
            appState = appState,
            onShowSnackbar = { message, action ->
                snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = action,
                    duration = SnackbarDuration.Short,
                ) == SnackbarResult.ActionPerformed
            }
        )
    }
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false