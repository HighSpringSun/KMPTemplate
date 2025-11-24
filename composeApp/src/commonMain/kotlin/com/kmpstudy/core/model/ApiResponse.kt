package com.kmpstudy.core.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SealedClassSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


@Serializable(with = ApiResponseSerializer::class)
sealed class ApiResponse<T> {
    abstract val code: Int
    abstract val message: String

    @Serializable
    @SerialName("Success")
    data class Success<T>(
        override val code: Int,
        override val message: String,
        val data: T
    ) : ApiResponse<T>()

    @Serializable
    @SerialName("Error")
    data class Error<T>(override val code: Int, override val message: String) : ApiResponse<T>()

    companion object {
        inline fun <reified T> success(data: T): Success<T> = Success(200, "success", data)

        fun <T> error(message: String, code: Int = 400): Error<T> = Error(code, message)
    }
}


@OptIn(InternalSerializationApi::class)
class ApiResponseSerializer<T>(valueSerializer: KSerializer<T>) : KSerializer<ApiResponse<T>> {
    private val serializer = SealedClassSerializer(
        ApiResponse::class.simpleName!!,
        ApiResponse::class,
        arrayOf(ApiResponse.Success::class, ApiResponse.Error::class),
        arrayOf(
            ApiResponse.Success.serializer(valueSerializer),
            ApiResponse.Error.serializer(valueSerializer)
        )
    )

    override val descriptor: SerialDescriptor = serializer.descriptor

    @Suppress("UNCHECKED_CAST")
    override fun deserialize(decoder: Decoder): ApiResponse<T> {
        return serializer.deserialize(decoder) as ApiResponse<T>
    }

    override fun serialize(encoder: Encoder, value: ApiResponse<T>) {
        serializer.serialize(encoder, value)
    }
}