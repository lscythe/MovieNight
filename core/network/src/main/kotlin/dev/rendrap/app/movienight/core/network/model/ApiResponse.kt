package dev.rendrap.app.movienight.core.network.model

sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Error<E>(
        val code: Int? = null,
        val throwable: Throwable
    ) : ApiResponse<E>()
}