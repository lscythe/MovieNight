package dev.rendrap.app.movienight.data.tmdb.mapper

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
    episode = episodes.map { it.toModel() }
)

fun EpisodeResponse.toModel() = Episode(
    airDate = airDate,
    episodeNumber = episodeNumber,
    episodeType = episodeType,
    name = name,
    runTime = runtime,
    stillPath = stillPath
)