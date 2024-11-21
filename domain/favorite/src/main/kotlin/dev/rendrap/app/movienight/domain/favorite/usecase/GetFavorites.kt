package dev.rendrap.app.movienight.domain.favorite.usecase

import dev.rendrap.app.movienight.core.common.utils.Constants.TEN
import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFavorites @Inject constructor(private val repo: FavoriteRepository) {
    suspend operator fun invoke(limit: Int = TEN) = repo.getFavorites(limit)

    operator fun invoke() = repo.getFavorites()
}