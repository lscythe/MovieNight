package dev.rendrap.app.movienight.core.network.model

sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data object Loading : ApiResponse<Nothing>()
    sealed class Error<E> : ApiResponse<E>() {
        data class ClientError(
            val code: Int,
            val errorBody: String?,
            val errorMessage: String?,
        ) : Error<Nothing>()

        data class ServerError(
            val code: Int,
            val errorMessage: String?,
        ) : Error<Nothing>()

        data class SerializationError(
            val errorMessage: String?,
            val message: String?,
        ) : Error<Nothing>()
    }
}