package dev.rendrap.app.movienight.domain.tmdb.usecase

import dev.rendrap.app.movienight.domain.tmdb.repository.TMDBRepository
import dev.rendrap.app.movienight.model.MediaType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCredits @Inject constructor(private val repo: TMDBRepository) {
    operator fun invoke(type: MediaType, id: Long) = repo.getCredits(type, id)
}