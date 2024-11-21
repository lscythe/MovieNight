package dev.rendrap.app.movienight.core.database.mapper

import dev.rendrap.app.movienight.core.common.utils.Constants.COMMA
import dev.rendrap.app.movienight.core.common.utils.Constants.EMPTY_STRING
import dev.rendrap.app.movienight.core.database.entity.FavoriteEntity
import dev.rendrap.app.movienight.model.Media

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