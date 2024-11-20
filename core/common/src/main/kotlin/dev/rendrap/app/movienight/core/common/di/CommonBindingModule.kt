package dev.rendrap.app.movienight.core.common.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.core.common.utils.NetworkMonitor
import dev.rendrap.app.movienight.core.common.utils.NetworkMonitorImpl

@Module
@InstallIn(SingletonComponent::class)
internal abstract class CommonBindingModule {
    @Binds
    abstract fun bindsNetworkMonitor(impl: NetworkMonitorImpl): NetworkMonitor
}