package dev.rendrap.app.movienight.domain.setting.usecase

import dev.rendrap.app.movienight.core.common.utils.Theme
import dev.rendrap.app.movienight.domain.setting.repository.SettingRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetCurrentTheme @Inject constructor(private val repo: SettingRepository) {
    suspend operator fun invoke(theme: Theme) = repo.setCurrentTheme(theme)
}