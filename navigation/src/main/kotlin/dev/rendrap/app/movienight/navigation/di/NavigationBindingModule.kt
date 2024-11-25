package dev.rendrap.app.movienight.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.feature.home.navigation.HomeNavigation
import dev.rendrap.app.movienight.navigation.NavigationManager
import dev.rendrap.app.movienight.navigation.NavigationManagerImpl
import dev.rendrap.app.movienight.navigation.route.HomeNavigationImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationBindingModule {
    @Binds
    abstract fun provideNavigationManager(impl: NavigationManagerImpl): NavigationManager

    @Binds
    abstract fun provideHomeNavigation(impl: HomeNavigationImpl): HomeNavigation
}