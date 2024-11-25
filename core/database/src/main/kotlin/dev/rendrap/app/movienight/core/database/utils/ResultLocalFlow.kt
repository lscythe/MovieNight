package dev.rendrap.app.movienight.core.database.utils

import dev.rendrap.app.movienight.core.common.Result
import kotlinx.coroutines.flow.flow

fun <T> resultLocalFlow(block: suspend () -> T) = flow {
    try {
        emit(Result.Success(block()))
    } catch (ex: Exception) {
        emit(Result.Failure(ex))
    }
}