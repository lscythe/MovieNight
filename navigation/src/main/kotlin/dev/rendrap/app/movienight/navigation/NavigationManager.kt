package dev.rendrap.app.movienight.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManager {
    private val _commands = MutableSharedFlow<NavigationCommand>()
    val commands = _commands.asSharedFlow()

    fun navigate(command: NavigationCommand) {
        _commands.tryEmit(command)
    }
}