package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.extension.orZero
import dev.rendrap.app.movienight.core.common.utils.Constants.EMPTY_STRING
import dev.rendrap.app.movienight.data.tmdb.dto.response.CastResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.CreditResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.CrewResponse
import dev.rendrap.app.movienight.model.CreditDetail
import dev.rendrap.app.movienight.model.Credits

fun CreditResponse.toModel() = Credits(
    casts = cast.orEmpty().map { it.toModel() },
    crews = crew.orEmpty().map { it.toModel() }
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
    id = id.orZero(),
    name = name.orEmpty(),
    originalName = originalName.orEmpty(),
    character = character.orEmpty(),
    avatar = profilePath.orEmpty(),
    job = EMPTY_STRING,
    title = title.orEmpty(),
    poster = posterPath.orEmpty()
)