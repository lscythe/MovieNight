package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.utils.Constants.EMPTY_STRING
import dev.rendrap.app.movienight.data.tmdb.dto.response.BaseResponses
import dev.rendrap.app.movienight.data.tmdb.dto.response.MovieDetailResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.MovieResponse
import dev.rendrap.app.movienight.model.Media
import dev.rendrap.app.movienight.model.MediaType
import dev.rendrap.app.movienight.model.Medias
import dev.rendrap.app.movienight.model.MovieDetail

internal fun BaseResponses<MovieResponse>.toModel(): Medias = this.results.map {
    it.toModel()
}

internal fun MovieResponse.toModel() = Media(
    id = id,
    name = title,
    originalName = originalTitle,
    overview = overview,
    rating = voteAverage,
    poster = posterPath,
    genres = genreIds.map { it.toMovieGenre() },
    adult = adult,
    type = MediaType.MOVIES,
    firstAirDate = EMPTY_STRING,
    releaseDate = releaseDate
)

internal fun MovieDetailResponse.toModel() = MovieDetail(
    id = id,
    name = title,
    originalName = originalTitle,
    genres = genres.map { it.name },
    originCountry = originCountry,
    poster = posterPath,
    homepage = homepage.orEmpty(),
    overview = overview,
    popularity = popularity,
    releaseDate = releaseDate,
    rating = voteAverage,
    ratingCount = voteCount
)