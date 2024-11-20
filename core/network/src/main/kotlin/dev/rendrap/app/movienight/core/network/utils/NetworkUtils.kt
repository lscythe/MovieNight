package dev.rendrap.app.movienight.core.network.utils

import dev.rendrap.app.movienight.core.network.model.ApiResponse
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.contentType
import kotlinx.serialization.SerializationException

suspend inline fun <reified T> safeRequest(
    block: () -> HttpResponse,
): ApiResponse<T> = try {
    ApiResponse.Success(block().body())
} catch (exception: ClientRequestException) {
    ApiResponse.Error.ClientError(
        code = exception.response.status.value,
        errorBody = exception.response.body(),
        errorMessage = exception.message,
    )
} catch (exception: ServerResponseException) {
    ApiResponse.Error.ServerError(
        code = exception.response.status.value,
        errorMessage = exception.message,
    )
} catch (exception: SerializationException) {
    ApiResponse.Error.SerializationError(
        message = exception.message,
        errorMessage = "Something went wrong while parsing the response",
    )
}

fun HttpMessageBuilder.defaultContentType() = contentType(ContentType.Application.Json)