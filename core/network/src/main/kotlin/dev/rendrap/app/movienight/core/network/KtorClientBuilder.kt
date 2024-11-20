package dev.rendrap.app.movienight.core.network

import dev.rendrap.app.movienight.core.common.extension.isValidUrl
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.CONNECT_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.READ_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.REQUEST_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.SOCKET_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.WRITE_TIMEOUT_MILLIS
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import org.jetbrains.annotations.TestOnly
import saschpe.log4k.Log
import java.util.concurrent.TimeUnit

class KtorClient {

    class Builder {
        var baseUrl: String = ""
            private set

        val interceptors: MutableList<Interceptor> = mutableListOf()

        var cacheEnable: Boolean = false
            private set

        var logEnable: Boolean = true
            private set
        var logLevel: LogLevel = LogLevel.BODY
            private set

        var connectTimeoutMillis: Long = CONNECT_TIMEOUT_MILLIS
            private set
        var readTimeoutMillis: Long = READ_TIMEOUT_MILLIS
            private set
        var requestTimeoutMillis: Long = REQUEST_TIMEOUT_MILLIS
            private set
        var socketTimeoutMillis: Long = SOCKET_TIMEOUT_MILLIS
            private set
        var writeTimeoutMillis: Long = WRITE_TIMEOUT_MILLIS
            private set

        fun setBaseUrl(baseUrl: String) = apply {
            require(baseUrl.isValidUrl()) { "Invalid URL: $baseUrl" }
            this.baseUrl = baseUrl
        }

        fun setTimeout(
            connectTimeoutMillis: Long = CONNECT_TIMEOUT_MILLIS,
            readTimeoutMillis: Long = READ_TIMEOUT_MILLIS,
            writeTimeoutMillis: Long = WRITE_TIMEOUT_MILLIS,
            requestTimeoutMillis: Long = REQUEST_TIMEOUT_MILLIS,
            socketTimeoutMillis: Long = SOCKET_TIMEOUT_MILLIS,
        ) = apply {
            require(connectTimeoutMillis > 0) { "Connect timeout must be positive" }
            require(readTimeoutMillis > 0) { "Read timeout must be positive" }
            require(writeTimeoutMillis > 0) { "Write timeout must be positive" }
            require(requestTimeoutMillis > 0) { "Request timeout must be positive" }
            require(socketTimeoutMillis > 0) { "Socket timeout must be positive" }
            this.connectTimeoutMillis = connectTimeoutMillis
            this.readTimeoutMillis = readTimeoutMillis
            this.writeTimeoutMillis = writeTimeoutMillis
            this.requestTimeoutMillis = requestTimeoutMillis
            this.socketTimeoutMillis = socketTimeoutMillis
        }

        fun addInterceptors(vararg interceptors: Interceptor) = apply {
            this.interceptors.addAll(interceptors)
        }

        fun setLogLevel(logLevel: LogLevel) = apply {
            this.logLevel = logLevel
        }

        fun disableLogging() = apply {
            this.logEnable = false
        }

        fun enableCache(saveCacheToFile: Boolean = false) = apply {
            this.cacheEnable = true
        }

        fun build(): HttpClient = HttpClient(OkHttp) {
            expectSuccess = true
            engine {
                config {
                    readTimeout(readTimeoutMillis, TimeUnit.MILLISECONDS)
                    writeTimeout(writeTimeoutMillis, TimeUnit.MILLISECONDS)
                    connectTimeout(connectTimeoutMillis, TimeUnit.MILLISECONDS)
                }
                interceptors.forEach { addInterceptor(it) }
            }
            defaultRequest {
                url(baseUrl)
            }
            install(ContentNegotiation) {
                json(jsonSerialization())
            }
            install(HttpTimeout) {
                requestTimeoutMillis = this@Builder.requestTimeoutMillis
                connectTimeoutMillis = this@Builder.connectTimeoutMillis
                socketTimeoutMillis = this@Builder.socketTimeoutMillis
            }
            apply {
                if (cacheEnable) {
                    install(HttpCache)
                }
                if (logEnable) {
                    install(Logging) {
                        level = logLevel
                        logger = object : Logger {
                            override fun log(message: String) = Log.info { message }
                        }
                    }
                }
            }
        }

        @TestOnly
        fun build(engine: HttpClientEngine) = HttpClient(engine) {
            expectSuccess = true
            install(ContentNegotiation) {
                json(jsonSerialization())
            }
        }

        private fun jsonSerialization() = Json {
            ignoreUnknownKeys = true
            isLenient = true
            prettyPrint = true
        }
    }

    companion object {
        private const val CACHE_DIRECTORY_PATH = "build/starter/cache"
    }
}