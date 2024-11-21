package dev.rendrap.app.movienight.core.common

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


sealed class Result<T> {
    data class Loading<T>(val data: T? = null) : Result<T>()
    data class Success<T>(val data: T) : Result<T>()
    data class Failure<T>(val exception: Throwable) : Result<T>()
}

@OptIn(ExperimentalContracts::class)
inline fun <R : Any, T> Result<T>.map(transform: (value: T) -> R): Result<R> {
    contract {
        callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Failure -> Result.Failure(exception)
        is Result.Loading -> Result.Loading()
    }
}