package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.data.tmdb.dto.response.BaseResponses
import dev.rendrap.app.movienight.data.tmdb.dto.response.SimilarResponse
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.MediaType

fun BaseResponses<SimilarResponse>.toModel(type: MediaType) = this.results.map {
    it.toModel(type)
}

fun SimilarResponse.toModel(type: MediaType) = Media(
    id = id,
    name = name,
    originalName = originalName,
    overview = overview,
    rating = voteAverage,
    poster = posterPath,
    genres = genreIds.map {
        when (type) {
            MediaType.TV_SERIES -> it.toTvGenre()
            MediaType.MOVIES -> it.toMovieGenre()
        }
    },
    adult = adult,
    type = type,
    firstAirDate = firstAirDate.orEmpty(),
    releaseDate = releaseDate.orEmpty()
)