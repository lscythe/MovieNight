package dev.rendrap.app.movienight.data.setting.datasource

import dev.rendrap.app.movienight.core.common.utils.Locales
import dev.rendrap.app.movienight.core.common.utils.Theme
import dev.rendrap.app.movienight.core.datastore.DatastoreManager
import dev.rendrap.app.movienight.core.datastore.di.PlainDatastore
import dev.rendrap.app.movienight.data.setting.utils.PreferencesKey.LanguageKey
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingLocalDataSource @Inject constructor(
    @PlainDatastore private val dsManager: DatastoreManager
) {
    suspend fun saveLanguage(value: String) = dsManager.save(value, LanguageKey)

    fun getLanguage() = dsManager.get(LanguageKey, Locales.EN_US)

    suspend fun saveTheme(value: Theme) = dsManager.save(value.name, LanguageKey)

    fun getTheme() = dsManager.get(LanguageKey, Theme.FOLLOW_SYSTEM.name)
}