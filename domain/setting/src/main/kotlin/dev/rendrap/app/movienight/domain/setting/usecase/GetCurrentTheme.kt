package dev.rendrap.app.movienight.domain.setting.usecase

import dev.rendrap.app.movienight.domain.setting.repository.SettingRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCurrentTheme @Inject constructor(private val repo: SettingRepository) {
    operator fun invoke() = repo.getCurrentTheme()
}