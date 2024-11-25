package dev.rendrap.app.movienight.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

interface NavigationManager {
    val commands: SharedFlow<NavigationCommand>
    fun navigate(command: NavigationCommand)
}

@Singleton
class NavigationManagerImpl @Inject constructor() : NavigationManager {
    private val _commands = MutableSharedFlow<NavigationCommand>()
    override val commands = _commands.asSharedFlow()

    override fun navigate(command: NavigationCommand) {
        _commands.tryEmit(command)
    }
}