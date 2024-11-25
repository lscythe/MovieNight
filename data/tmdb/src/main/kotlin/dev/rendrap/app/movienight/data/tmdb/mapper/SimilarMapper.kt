package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.extension.orFalse
import dev.rendrap.app.movienight.core.common.extension.orZero
import dev.rendrap.app.movienight.data.tmdb.dto.response.BaseResponses
import dev.rendrap.app.movienight.data.tmdb.dto.response.SimilarResponse
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.MediaType

fun BaseResponses<SimilarResponse>.toModel(type: MediaType) = this.results.map {
    it.toModel(type)
}

fun SimilarResponse.toModel(type: MediaType) = Media(
    id = id.orZero(),
    name = name.orEmpty(),
    originalName = originalName.orEmpty(),
    overview = overview.orEmpty(),
    rating = voteAverage.orZero(),
    poster = posterPath.orEmpty(),
    genres = genreIds.orEmpty().map {
        when (type) {
            MediaType.TV_SERIES -> it.toTvGenre()
            MediaType.MOVIES -> it.toMovieGenre()
        }
    },
    adult = adult.orFalse(),
    type = type,
    firstAirDate = firstAirDate.orEmpty(),
    releaseDate = releaseDate.orEmpty()
)