package dev.rendrap.app.movienight.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.rendrap.app.movienight.ui.MovieNightAppState

@Composable
fun MovieNightNavHost(
    appState: MovieNightAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    MVNavHost(
        navHostController = navController,
        modifier = modifier,
        onShowSnackbar = onShowSnackbar
    )
}