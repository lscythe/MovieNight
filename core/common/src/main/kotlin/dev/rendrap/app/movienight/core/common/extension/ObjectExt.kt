package dev.rendrap.app.movienight.core.common.extension

fun <T> T?.isNotNull() = this != null

fun <T> T?.isNull() = this == null