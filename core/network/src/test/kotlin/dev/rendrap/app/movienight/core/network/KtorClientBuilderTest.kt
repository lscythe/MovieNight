package dev.rendrap.app.movienight.core.network

import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.CONNECT_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.READ_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.REQUEST_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.SOCKET_TIMEOUT_MILLIS
import dev.rendrap.app.movienight.core.network.utils.NetworkConfig.WRITE_TIMEOUT_MILLIS
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.ktor.client.plugins.logging.LogLevel
import io.mockk.mockk
import okhttp3.Interceptor

class KtorClientBuilderTest : BehaviorSpec(
    {
        lateinit var sut: KtorClient.Builder

        beforeSpec {
            sut = KtorClient.Builder()
        }

        Context("builder set base URL") {
            Given("a valid URL") {
                val validUrl = "https://example.com"

                When("setting the base URL") {
                    sut.setBaseUrl(validUrl)

                    Then("the base URL is valid and set correctly") {
                        sut.baseUrl shouldBe validUrl
                    }
                }
            }
            Given("an invalid URL") {
                val invalidUrl = "invalid-url"

                When("setting the base URL") {
                    Then("the base URL is not valid") {
                        shouldThrowExactly<IllegalArgumentException> {
                            sut.setBaseUrl(invalidUrl)
                        }
                    }
                }
            }
        }

        Context("builder can set timeout") {
            When("setting timeout") {
                sut.setTimeout()
                Then("the timeout should be default value") {
                    sut.connectTimeoutMillis shouldBe CONNECT_TIMEOUT_MILLIS
                    sut.readTimeoutMillis shouldBe READ_TIMEOUT_MILLIS
                    sut.writeTimeoutMillis shouldBe WRITE_TIMEOUT_MILLIS
                    sut.socketTimeoutMillis shouldBe SOCKET_TIMEOUT_MILLIS
                    sut.requestTimeoutMillis shouldBe REQUEST_TIMEOUT_MILLIS
                }
            }
            Given("a positive timeout") {
                val timeout = 10_000L
                When("setting the timeout") {
                    sut.setTimeout(connectTimeoutMillis = timeout)
                    Then("the timeout should be set correctly") {
                        sut.connectTimeoutMillis shouldBe timeout
                    }
                }
            }
            Given("a negative timeout") {
                val timeout = -1L
                When("setting the timeout") {
                    shouldThrowExactly<IllegalArgumentException> {
                        sut.setTimeout(connectTimeoutMillis = timeout)
                    }
                }
            }
        }

        Context("builder add interceptors correctly") {
            Given("an interceptor") {
                val interceptor = mockk<Interceptor>()

                When("adding the interceptor") {
                    sut.addInterceptors(interceptor)

                    Then("the interceptor should be added") {
                        sut.interceptors shouldContainExactly listOf(interceptor)
                    }
                }
            }
            Given("multiple interceptors") {
                val interceptor1 = mockk<Interceptor>()
                val interceptor2 = mockk<Interceptor>()

                When("adding the interceptors") {
                    sut.addInterceptors(interceptor1, interceptor2)

                    Then("the interceptors should be added") {
                        sut.interceptors shouldContainExactly listOf(interceptor1, interceptor2)
                    }
                }
            }
        }

        Context("builder set log level correctly") {
            Given("a log level") {
                val logLevel = LogLevel.INFO

                When("setting the log level") {
                    sut.setLogLevel(logLevel)

                    Then("the log level should be set correctly") {
                        sut.logLevel shouldBe logLevel
                    }
                }
            }
        }

        Context("builder should be able to enable and disable logging") {
            When("build the builder") {
                sut.build()
                Then("logging should be enabled by default") {
                    sut.logEnable shouldBe true
                }
            }
            When("disable the logging") {
                sut.disableLogging()
                Then("logging should be disabled") {
                    sut.logEnable shouldBe false
                }
            }
        }

        Context("builder should be able to enable and disable cache") {
            When("build the builder") {
                sut.build()
                Then("cache should be disabled by default") {
                    sut.cacheEnable shouldBe false
                }
            }
            When("enable cache") {
                sut.enableCache()
                Then("cache should be enabled and save to file should be disabled") {
                    sut.cacheEnable shouldBe true
                }
            }
        }

        afterTest {
            sut = KtorClient.Builder()
        }
    }
)