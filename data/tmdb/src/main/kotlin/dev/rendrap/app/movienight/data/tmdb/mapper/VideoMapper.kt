package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.data.tmdb.dto.response.BaseResponses
import dev.rendrap.app.movienight.data.tmdb.dto.response.VideoResponse
import dev.rendrap.app.movienight.model.Video

fun BaseResponses<VideoResponse>.toModel() = this.results.map {
    it.toModel()
}

fun VideoResponse.toModel() = Video(
    name = name,
    key = key,
    site = site,
    publishedAt = publishedAt
)