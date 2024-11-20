package dev.rendrap.app.movienight.domain.tmdb.usecase

import dev.rendrap.app.movienight.domain.tmdb.parameter.TvParameter
import dev.rendrap.app.movienight.domain.tmdb.repository.TMDBRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetTvSeries @Inject constructor(private val repo: TMDBRepository) {
    operator fun invoke(param: TvParameter) = repo.getTvSeries(param)
}