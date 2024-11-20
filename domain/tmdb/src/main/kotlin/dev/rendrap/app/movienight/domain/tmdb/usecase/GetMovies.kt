package dev.rendrap.app.movienight.domain.tmdb.usecase

import dev.rendrap.app.movienight.domain.tmdb.parameter.MovieParameter
import dev.rendrap.app.movienight.domain.tmdb.repository.TMDBRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMovies @Inject constructor(private val repo: TMDBRepository) {
    operator fun invoke(param: MovieParameter) = repo.getMovies(param)
}