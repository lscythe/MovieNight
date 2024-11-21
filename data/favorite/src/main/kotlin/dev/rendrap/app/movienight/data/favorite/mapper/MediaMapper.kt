package dev.rendrap.app.movienight.data.favorite.mapper

import dev.rendrap.app.movienight.core.common.utils.Constants.COMMA
import dev.rendrap.app.movienight.core.common.utils.Constants.EMPTY_STRING
import dev.rendrap.app.movienight.core.database.entity.FavoriteEntity
import dev.rendrap.app.movienight.core.database.entity.MediaEntity
import dev.rendrap.app.movienight.model.Media
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate

fun Media.toFavoriteEntity() = FavoriteEntity(
    id = id,
    title = name,
    originalTitle = originalName,
    poster = poster,
    genres = genres.joinToString(COMMA),
    rating = rating,
    type = type,
    adult = adult,
    releaseDate = if (releaseDate.isBlank()) null else LocalDate.parse(releaseDate),
    firstAirDate = if (firstAirDate.isBlank()) null else LocalDate.parse(firstAirDate),
    createdAt = Clock.System.now()
)

fun Media.toEntity(playlistId: Int) = MediaEntity(
    id = id,
    title = name,
    originalTitle = originalName,
    poster = poster,
    genres = genres.joinToString(COMMA),
    rating = rating,
    type = type,
    adult = adult,
    releaseDate = if (releaseDate.isBlank()) null else LocalDate.parse(releaseDate),
    firstAirDate = if (firstAirDate.isBlank()) null else LocalDate.parse(firstAirDate),
    playlistId = playlistId
)

fun MediaEntity.toModel() = Media(
    id = id,
    name = title,
    originalName = originalTitle,
    overview = EMPTY_STRING,
    rating = rating,
    poster = poster,
    genres = genres.split(COMMA),
    adult = adult,
    type = type,
    firstAirDate = firstAirDate.toString(),
    releaseDate = releaseDate.toString()
)

fun FavoriteEntity.toModel() = Media(
    id = id,
    name = title,
    originalName = originalTitle,
    overview = EMPTY_STRING,
    rating = rating,
    poster = poster,
    genres = genres.split(COMMA),
    adult = adult,
    type = type,
    firstAirDate = firstAirDate.toString(),
    releaseDate = releaseDate.toString()
)
