package dev.rendrap.app.movienight.data.setting.utils

import androidx.datastore.preferences.core.stringPreferencesKey

internal object PreferencesKey {
    val LanguageKey = stringPreferencesKey("language")
    val ThemeKey = stringPreferencesKey("theme")
}