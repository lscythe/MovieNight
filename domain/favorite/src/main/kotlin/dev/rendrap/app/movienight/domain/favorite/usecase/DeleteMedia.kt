package dev.rendrap.app.movienight.domain.favorite.usecase

import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import dev.rendrap.app.movienight.model.Media
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteMedia @Inject constructor(private val repo: FavoriteRepository) {
    suspend operator fun invoke(vararg media: Media, playlistId: Int) =
        repo.deleteMedia(*media, playlistId = playlistId)
}