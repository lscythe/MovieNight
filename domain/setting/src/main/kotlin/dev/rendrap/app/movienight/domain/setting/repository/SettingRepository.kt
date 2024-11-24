package dev.rendrap.app.movienight.domain.setting.repository

import dev.rendrap.app.movienight.core.common.utils.Theme

interface SettingRepository {
    suspend fun getCurrentLanguage(): String
    suspend fun getCurrentTheme(): Theme
    suspend fun setCurrentLanguage(language: String)
    suspend fun setCurrentTheme(theme: Theme)
}