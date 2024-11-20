package dev.rendrap.app.movienight.domain.tmdb.usecase

import dev.rendrap.app.movienight.domain.tmdb.repository.TMDBRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPeopleDetail @Inject constructor(private val repo: TMDBRepository) {
    operator fun invoke(id: Long) = repo.getPeopleDetail(id)
}