package com.kmpstudy.data.network.client

import com.kmpstudy.core.logger.logger
import com.kmpstudy.core.util.serializer.InstantSerializer
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

abstract class BaseClient {

    companion object {
//        private const val BASE_URL = "http://10.150.12.105:8080/api/"
//    private const val BASE_URL = "http://127.0.0.1:11000/api/"
    private const val BASE_URL = "https://www.kmpstudy.com/sleeptracker/api/"
    }

    protected val clientLogger = logger()

    @OptIn(ExperimentalTime::class)
    protected val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                serializersModule = SerializersModule {
                    contextual(Instant::class) { InstantSerializer }

                }
                classDiscriminator = "type"

                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    clientLogger.d { message }
                }
            }
            level = LogLevel.BODY
//            filter { request ->
//                request.url.host.contains("ktor.io")
//            }
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000
            connectTimeoutMillis = 15000
            socketTimeoutMillis = 15000
        }
        install(Resources)



        defaultRequest {
            url(BASE_URL)
            contentType(ContentType.Application.Json)
        }
    }

    abstract fun createClient(): HttpClient

}