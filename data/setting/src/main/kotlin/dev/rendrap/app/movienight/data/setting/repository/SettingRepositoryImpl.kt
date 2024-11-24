package dev.rendrap.app.movienight.data.setting.repository

import dev.rendrap.app.movienight.core.common.utils.Theme
import dev.rendrap.app.movienight.data.setting.datasource.SettingLocalDataSource
import dev.rendrap.app.movienight.domain.setting.repository.SettingRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingRepositoryImpl @Inject constructor(
    private val localSource: SettingLocalDataSource
) : SettingRepository {
    override suspend fun getCurrentLanguage(): String = localSource.getLanguage()

    override suspend fun getCurrentTheme(): Theme = localSource.getTheme()

    override suspend fun setCurrentLanguage(language: String) = localSource.saveLanguage(language)

    override suspend fun setCurrentTheme(theme: Theme) = localSource.saveTheme(theme)

}