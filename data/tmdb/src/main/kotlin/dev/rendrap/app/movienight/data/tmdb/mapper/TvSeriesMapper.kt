package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.extension.orFalse
import dev.rendrap.app.movienight.core.common.extension.orZero
import dev.rendrap.app.movienight.core.common.utils.Constants.EMPTY_STRING
import dev.rendrap.app.movienight.data.tmdb.dto.response.BaseResponses
import dev.rendrap.app.movienight.data.tmdb.dto.response.TvSeriesDetailResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.TvSeriesResponse
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.TvSeriesDetail

fun BaseResponses<TvSeriesResponse>.toModel() = this.results.map {
    it.toModel()
}

fun TvSeriesResponse.toModel() = Media(
    id = id.orZero(),
    name = name.orEmpty(),
    originalName = originalName.orEmpty(),
    overview = overview.orEmpty(),
    rating = voteAverage.orZero(),
    poster = posterPath.orEmpty(),
    genres = genreIds.orEmpty().map { it.toTvGenre() },
    adult = adult.orFalse(),
    type = MediaType.TV_SERIES,
    firstAirDate = firstAirDate.orEmpty(),
    releaseDate = EMPTY_STRING
)

fun TvSeriesDetailResponse.toModel() = TvSeriesDetail(
    id = id.orZero(),
    adult = adult.orFalse(),
    name = name.orEmpty(),
    originalName = originalName.orEmpty(),
    genres = genres.orEmpty().map { it.name.orEmpty() },
    homepage = homepage.orEmpty(),
    firstAirDate = firstAirDate.orEmpty(),
    poster = posterPath.orEmpty(),
    rating = voteAverage.orZero(),
    ratingCount = voteCount.orZero(),
    originCountry = originCountry.orEmpty(),
    seasons = seasons.orEmpty().map { it.toModel() }
)