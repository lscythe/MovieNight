package dev.rendrap.app.movienight.core.network.utils

import dev.rendrap.app.movienight.core.common.Result
import dev.rendrap.app.movienight.core.network.BuildConfig
import dev.rendrap.app.movienight.core.network.model.ApiResponse
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.contentType
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException

suspend inline fun <reified T> safeRequest(
    block: () -> HttpResponse,
): ApiResponse<T> = try {
    ApiResponse.Success(block().body())
} catch (exception: ClientRequestException) {
    if (BuildConfig.DEBUG) throw exception
    ApiResponse.Error(
        code = exception.response.status.value,
        throwable = exception,
    )
} catch (exception: ServerResponseException) {
    if (BuildConfig.DEBUG) throw exception
    ApiResponse.Error(
        code = exception.response.status.value,
        throwable = exception,
    )
} catch (exception: SerializationException) {
    if (BuildConfig.DEBUG) throw exception
    ApiResponse.Error(
        throwable = Exception("Something went wrong while parsing the response"),
    )
} catch (ex: Exception) {
    if (BuildConfig.DEBUG) throw ex
    ApiResponse.Error(
        throwable = ex
    )
}

fun HttpMessageBuilder.defaultContentType() = contentType(ContentType.Application.Json)

fun <T> resultFlow(block: suspend () -> ApiResponse<T>) = flow {
    val result = block()
    emit(
        when (result) {
            is ApiResponse.Success -> Result.Success(result.data)
            is ApiResponse.Error -> Result.Failure(result.throwable)
        }
    )
}