package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.utils.Constants.EMPTY_STRING
import dev.rendrap.app.movienight.data.tmdb.dto.response.CastResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.CreditResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.CrewResponse
import dev.rendrap.app.movienight.model.CreditDetail
import dev.rendrap.app.movienight.model.Credits

fun CreditResponse.toModel() = Credits(
    casts = cast.map { it.toModel() },
    crews = crew.map { it.toModel() }
)

fun CrewResponse.toModel() = CreditDetail(
    id = id,
    name = name,
    originalName = originalName,
    character = EMPTY_STRING,
    avatar = profilePath,
    job = job,
    title = title.orEmpty(),
    poster = posterPath.orEmpty(),
)

fun CastResponse.toModel() = CreditDetail(
    id = id,
    name = name,
    originalName = originalName,
    character = character,
    avatar = profilePath,
    job = EMPTY_STRING,
    title = title.orEmpty(),
    poster = posterPath.orEmpty()
)