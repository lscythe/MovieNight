package dev.rendrap.app.movienight.domain.favorite.usecase

import dev.rendrap.app.movienight.domain.favorite.repository.FavoriteRepository
import dev.rendrap.app.movienight.model.Media
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddFavorite @Inject constructor(private val repo: FavoriteRepository) {
    suspend operator fun invoke(media: Media) = repo.addFavorite(media)
}