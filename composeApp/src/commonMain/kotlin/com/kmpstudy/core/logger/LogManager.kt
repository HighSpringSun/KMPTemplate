package com.kmpstudy.core.logger

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.Severity

object LogManager {
    private val baseLogger = createBaseLogger()

    private fun createBaseLogger(): Logger {
        return Logger(
            config = StaticConfig()
        )
    }

    fun getLogger(tag: String): Logger = baseLogger.withTag(tag)
    fun getNetworkLogger(): Logger = getLogger("Network")
    fun getDatabaseLogger(): Logger = getLogger("Database")

//    expect fun platformLogWriters(): List<LogWriter>
}