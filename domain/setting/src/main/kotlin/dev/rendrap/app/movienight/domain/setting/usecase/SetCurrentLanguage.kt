package dev.rendrap.app.movienight.domain.setting.usecase

import dev.rendrap.app.movienight.domain.setting.repository.SettingRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetCurrentLanguage @Inject constructor(private val repo: SettingRepository) {
    suspend operator fun invoke(language: String) = repo.setCurrentLanguage(language)
}