package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.extension.orZero
import dev.rendrap.app.movienight.data.tmdb.dto.response.EpisodeResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.SeasonDetailResponse
import dev.rendrap.app.movienight.data.tmdb.dto.response.SeasonResponse
import dev.rendrap.app.movienight.model.Episode
import dev.rendrap.app.movienight.model.Season
import dev.rendrap.app.movienight.model.SeasonDetail

fun SeasonResponse.toModel() = Season(
    name = name,
    seasonNumber = seasonNumber
)

fun SeasonDetailResponse.toModel() = SeasonDetail(
    episode = episodes.orEmpty().map { it.toModel() }
)

fun EpisodeResponse.toModel() = Episode(
    airDate = airDate.orEmpty(),
    episodeNumber = episodeNumber.orZero(),
    episodeType = episodeType.orEmpty(),
    name = name.orEmpty(),
    runTime = runtime.orZero(),
    stillPath = stillPath.orEmpty()
)