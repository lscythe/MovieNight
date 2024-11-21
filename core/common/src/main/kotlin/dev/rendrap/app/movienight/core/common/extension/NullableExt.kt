package dev.rendrap.app.movienight.core.common.extension

import dev.rendrap.app.movienight.core.common.utils.Constants.ZERO_INT

fun Int?.orZero() = this ?: ZERO_INT