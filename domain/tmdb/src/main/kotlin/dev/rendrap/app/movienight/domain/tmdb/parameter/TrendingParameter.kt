package dev.rendrap.app.movienight.domain.tmdb.parameter

import dev.rendrap.app.movienight.model.MediaType

data class TrendingParameter(
    val type: MediaType,
    val language: String = "en-US",
    val timeWindow: TimeWindow = TimeWindow.DAY,
)

enum class TimeWindow {
    DAY,
    WEEK
}

enum class TrendingType {
    TV,
    MOVIE
}