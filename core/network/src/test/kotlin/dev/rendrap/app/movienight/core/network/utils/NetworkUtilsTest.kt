package dev.rendrap.app.movienight.core.network.utils

import dev.rendrap.app.movienight.core.network.KtorClient
import dev.rendrap.app.movienight.core.network.model.ApiResponse
import dev.rendrap.app.movienight.core.network.model.TestResponse
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondBadRequest
import io.ktor.client.engine.mock.respondError
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class NetworkUtilsTest : BehaviorSpec(
    {
        val url = "https://example.com"
        val mockResponse = TestResponse("key", "value")
        val mockResponseJson = Json.encodeToString(mockResponse)

        Context("safeRequest function should return an ApiResponse.Success") {
            Given("a successful response") {
                val mockEngine = MockEngine {
                    respond(
                        content = mockResponseJson,
                        status = HttpStatusCode.OK,
                        headers = headersOf(
                            HttpHeaders.ContentType,
                            ContentType.Application.Json.toString(),
                        ),
                    )
                }
                When("safeRequest is called") {
                    val client = KtorClient.Builder().build(mockEngine)
                    runTest {
                        val response = safeRequest<TestResponse> { client.get(url) }
                        Then("it should return ApiResponse.Success") {
                            response.shouldBeInstanceOf<ApiResponse.Success<TestResponse>>()
                            client.close()
                        }
                    }
                }
            }
        }
        Context("safeRequest function should return an ApiResponse.Error.ClientError") {
            Given("a client request exception") {
                val mockEngine = MockEngine {
                    respondBadRequest()
                }
                When("safeRequest is called") {
                    val client = KtorClient.Builder().build(mockEngine)
                    runTest {
                        val response = safeRequest<TestResponse> { client.get(url) }

                        Then("it should return ApiResponse.Error.ClientError") {
                            response.shouldBeInstanceOf<ApiResponse.Error.ClientError>()
                            client.close()
                        }
                    }
                }
            }
        }
        Context("safeRequest function should return an ApiResponse.Error.ServerError") {
            Given("a server response exception") {
                val mockEngine = MockEngine {
                    respondError(
                        status = HttpStatusCode.InternalServerError)
                }

                When("safeRequest is called") {
                    val client = KtorClient.Builder().build(mockEngine)

                    runTest {
                        val response = safeRequest<TestResponse> { client.get(url) }

                        Then("it should return ApiResponse.Error.ServerError") {
                            response.shouldBeInstanceOf<ApiResponse.Error.ServerError>()
                            client.close()
                        }
                    }
                }
            }
        }
    }
)