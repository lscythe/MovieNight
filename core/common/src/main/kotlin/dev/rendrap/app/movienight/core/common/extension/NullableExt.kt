package dev.rendrap.app.movienight.core.common.extension

import dev.rendrap.app.movienight.core.common.utils.Constants.ZERO

fun Int?.orZero() = this ?: ZERO

fun Double?.orZero() = this ?: 0.0

fun Float?.orZero() = this ?: 0f

fun Long?.orZero() = this ?: 0L

fun Boolean?.orFalse() = this ?: false

fun Boolean?.orTrue() = this ?: true