package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.model.MovieGenreType
import dev.rendrap.app.movienight.model.TvGenreType

fun Int.toMovieGenre(): String =
    MovieGenreType.entries.firstOrNull { it.id == this }?.value.orEmpty()

fun Int.toTvGenre(): String =
    TvGenreType.entries.firstOrNull { it.id == this }?.value.orEmpty()