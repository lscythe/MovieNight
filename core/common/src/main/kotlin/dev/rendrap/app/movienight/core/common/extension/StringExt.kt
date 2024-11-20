package dev.rendrap.app.movienight.core.common.extension

import dev.rendrap.app.movienight.core.common.utils.Constants.URL_REGEX

fun String.isValidUrl(): Boolean = this.matches(Regex(URL_REGEX))
