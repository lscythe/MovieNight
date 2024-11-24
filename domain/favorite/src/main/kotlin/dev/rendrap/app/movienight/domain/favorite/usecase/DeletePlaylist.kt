package dev.rendrap.app.movienight.domain.favorite.usecase

import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import dev.rendrap.app.movienight.model.Playlist
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeletePlaylist @Inject constructor(private val repo: FavoriteRepository) {
    suspend operator fun invoke(vararg playlist: Playlist) = repo.deletePlaylist(*playlist)
}