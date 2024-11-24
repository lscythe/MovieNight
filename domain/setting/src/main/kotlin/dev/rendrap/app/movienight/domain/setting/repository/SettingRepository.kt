package dev.rendrap.app.movienight.domain.setting.repository

import dev.rendrap.app.movienight.core.common.utils.Theme

interface SettingRepository {
    suspend fun getCurrentLanguage(): Theme
    suspend fun getCurrentTheme(): String
}