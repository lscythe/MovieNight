package dev.rendrap.app.movienight.domain.favorite

import dev.rendrap.app.movienight.core.common.utils.Constants.TEN
import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPlaylists @Inject constructor(private val repo: FavoriteRepository) {
    suspend operator fun invoke(limit: Int = TEN) = repo.getPlaylists(limit)

    operator fun invoke() = repo.getPlaylists()
}