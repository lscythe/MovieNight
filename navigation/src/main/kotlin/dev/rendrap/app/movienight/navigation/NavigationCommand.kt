package dev.rendrap.app.movienight.navigation

import androidx.navigation.NavOptions
import kotlin.reflect.KClass

sealed interface NavigationCommand {
    data object NavigateBack : NavigationCommand
    data object NavigateHome : NavigationCommand
    data class NavigateTo(
        val destination: KClass<*>,
        val navOptions: NavOptions? = null
    ) : NavigationCommand
}