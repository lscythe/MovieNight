package dev.rendrap.app.movienight.domain.favorite.usecase

import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddPlaylist @Inject constructor(private val repo: FavoriteRepository) {
    suspend operator fun invoke(name: String) = repo.addPlaylist(name)
}