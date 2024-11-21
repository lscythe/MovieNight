package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.core.common.extension.orZero
import dev.rendrap.app.movienight.data.tmdb.dto.response.BaseResponses
import dev.rendrap.app.movienight.data.tmdb.dto.response.ReviewResponse
import dev.rendrap.app.movienight.model.Review

fun BaseResponses<ReviewResponse>.toModel() = this.results.map {
    it.toModel()
}

fun ReviewResponse.toModel() = Review(
    username = authorDetails.username,
    avatar = authorDetails.avatarPath.orEmpty(),
    date = createdAt,
    content = content,
    rating = authorDetails.rating.orZero()
)