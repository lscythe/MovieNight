package dev.rendrap.app.movienight.data.setting.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rendrap.app.movienight.data.setting.repository.SettingRepositoryImpl
import dev.rendrap.app.movienight.domain.setting.repository.SettingRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingDataModule {
    @Binds
    abstract fun settingRepository(impl: SettingRepositoryImpl): SettingRepository
}