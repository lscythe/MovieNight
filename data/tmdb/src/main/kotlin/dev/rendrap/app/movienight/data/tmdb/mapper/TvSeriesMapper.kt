package dev.rendrap.app.movienight.data.tmdb.mapper

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
    id = id,
    name = name,
    originalName = originalName,
    overview = overview,
    rating = voteAverage,
    poster = posterPath,
    genres = genreIds.map { it.toTvGenre() },
    adult = adult,
    type = MediaType.TV_SERIES,
    firstAirDate = firstAirDate,
    releaseDate = EMPTY_STRING
)

fun TvSeriesDetailResponse.toModel() = TvSeriesDetail(
    id = id,
    adult = adult,
    name = name,
    originalName = originalName,
    genres = genres.map { it.name },
    homepage = homepage.orEmpty(),
    firstAirDate = firstAirDate,
    poster = posterPath,
    rating = voteAverage,
    ratingCount = voteCount,
    originCountry = originCountry,
    seasons = seasons.map { it.toModel() }
)