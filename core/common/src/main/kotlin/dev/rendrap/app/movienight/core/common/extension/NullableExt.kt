package dev.rendrap.app.movienight.core.common.extension

import dev.rendrap.app.movienight.core.common.utils.Constants.ZERO

fun Int?.orZero() = this ?: ZERO