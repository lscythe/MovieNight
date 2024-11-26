package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.extension.orFalse
import dev.rendrap.app.movienight.core.common.extension.orZero
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
    id = id.orZero(),
    name = title.orEmpty(),
    originalName = originalTitle.orEmpty(),
    overview = overview.orEmpty(),
    rating = voteAverage.orZero(),
    poster = posterPath.orEmpty(),
    genres = genreIds.orEmpty().map { it.toMovieGenre() },
    adult = adult.orFalse(),
    type = MediaType.MOVIES,
    firstAirDate = EMPTY_STRING,
    releaseDate = releaseDate.orEmpty()
)

internal fun MovieDetailResponse.toModel() = MovieDetail(
    id = id.orZero(),
    name = title.orEmpty(),
    originalName = originalTitle.orEmpty(),
    genres = genres.orEmpty().map { it.name.orEmpty() },
    originCountry = originCountry.orEmpty(),
    poster = posterPath.orEmpty(),
    homepage = homepage.orEmpty(),
    overview = overview.orEmpty(),
    popularity = popularity.orZero(),
    releaseDate = releaseDate.orEmpty(),
    rating = voteAverage.orZero(),
    ratingCount = voteCount.orZero(),
    adult = adult.orFalse()
)