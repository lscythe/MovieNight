package dev.rendrap.app.movienight.core.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class IODispatcher

@Qualifier
@Retention
annotation class DefaultDispatcher

@Qualifier
@Retention
annotation class MainDispatcher

@Qualifier
@Retention
annotation class MainImmediateDispatcher

@Module
@InstallIn(SingletonComponent::class)
internal object CoroutinesDispatcherModule {
    @Provides
    @Singleton
    @IODispatcher
    fun provideIODispatcher() = Dispatchers.IO

    @Provides
    @Singleton
    @DefaultDispatcher
    fun provideDefaultDispatcher() = Dispatchers.Default

    @Provides
    @Singleton
    @MainDispatcher
    fun provideMainDispatcher() = Dispatchers.Main

    @Provides
    @Singleton
    @MainImmediateDispatcher
    fun provideMainImmediateDispatcher() = Dispatchers.Main.immediate

}