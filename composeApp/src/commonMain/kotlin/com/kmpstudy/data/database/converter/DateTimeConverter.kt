package com.kmpstudy.data.database.converter

import androidx.compose.ui.window.Popup
import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class DateTimeConverter {

    @TypeConverter
    @OptIn(ExperimentalTime::class)
    fun fromInstant(instant: Instant): Long {
        return instant.toEpochMilliseconds()
    }

    @OptIn(ExperimentalTime::class)
    @TypeConverter
    fun toInstant(millis: Long): Instant {
        return Instant.fromEpochMilliseconds(millis)
    }

    @TypeConverter
    fun fromLocalDate(date: LocalDate): String {
        return date.format(LocalDate.Formats.ISO)
    }

    @TypeConverter
    fun toLocalDate(dateString: String): LocalDate {
        return LocalDate.parse(dateString, LocalDate.Formats.ISO)
    }
}
