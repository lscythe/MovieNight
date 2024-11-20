package dev.rendrap.app.movienight.domain.tmdb.parameter

data class TrendingParameter(
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