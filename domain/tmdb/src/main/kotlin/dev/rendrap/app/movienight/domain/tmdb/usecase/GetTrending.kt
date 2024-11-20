package dev.rendrap.app.movienight.domain.tmdb.usecase

import dev.rendrap.app.movienight.domain.tmdb.parameter.TrendingParameter
import dev.rendrap.app.movienight.domain.tmdb.repository.TMDBRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetTrending @Inject constructor(private val repo: TMDBRepository) {
    operator fun invoke(param: TrendingParameter) = repo.getTrending(param)
}