package dev.rendrap.app.movienight.domain.setting.repository

import dev.rendrap.app.movienight.core.common.utils.Theme
import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getCurrentLanguage(): Flow<String>
    fun getCurrentTheme(): Flow<String>
    suspend fun setCurrentLanguage(language: String)
    suspend fun setCurrentTheme(theme: Theme)
}