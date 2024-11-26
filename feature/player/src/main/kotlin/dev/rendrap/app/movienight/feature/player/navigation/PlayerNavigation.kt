package dev.rendrap.app.movienight.feature.player.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import kotlinx.serialization.Serializable

sealed interface PlayerRoute {
    @Serializable
    data class Player(val url: String) : PlayerRoute
}

fun NavController.navigateToPlayer(url: String, navOptions: NavOptions? = null) =
    navigate(PlayerRoute.Player(url), navOptions = navOptions)