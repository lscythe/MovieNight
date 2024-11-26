package dev.rendrap.app.movienight.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
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

fun NavController.navigateToHome(
    destination: HomeRoute = HomeRoute.Discover,
    navOptions: NavOptions
) = navigate(route = destination, navOptions = navOptions)