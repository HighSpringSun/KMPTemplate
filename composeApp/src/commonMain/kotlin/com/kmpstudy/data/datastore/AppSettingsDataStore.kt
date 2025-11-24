package com.kmpstudy.data.datastore

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.IOException
import androidx.datastore.core.okio.OkioSerializer
import androidx.datastore.core.okio.OkioStorage
import com.kmpstudy.core.logger.logger
import com.kmpstudy.data.model.AppSettings
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okio.BufferedSink
import okio.BufferedSource
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import okio.use
import kotlin.time.ExperimentalTime

const val appSettingsJsonFileName = "app_settings.json"

object AppSettingsSerializer : OkioSerializer<AppSettings> {
    @OptIn(ExperimentalTime::class)
    override val defaultValue: AppSettings
        get() = AppSettings()

    override suspend fun readFrom(source: BufferedSource): AppSettings =
        Json.decodeFromString(source.readUtf8())

    override suspend fun writeTo(t: AppSettings, sink: BufferedSink) {
        sink.use {
            it.writeUtf8(Json.encodeToString(t))
        }
    }

}

class AppSettingsDataStore(
    producePath: () -> String
) {
    private val logger = logger()
    private val dataStore = DataStoreFactory.create(
        storage = OkioStorage(
            fileSystem = FileSystem.SYSTEM,
            serializer = AppSettingsSerializer,
            producePath = {
                producePath().toPath()
            }
        ),
    )

    val appSettings = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                logger.e("Error reading app config", exception)
            } else {
                throw exception
            }
        }

    suspend fun updateSettings(transform: (AppSettings) -> AppSettings) {
        dataStore.updateData { currentSettings ->
            transform(currentSettings)
        }
    }

}


expect fun producePath(fileName: String): String