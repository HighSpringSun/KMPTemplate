package com.kmpstudy.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.kmpstudy.data.database.converter.DateTimeConverter

@Database(
    entities = [],
    version = 2,
    exportSchema = false
)
@ConstructedBy(AppDatabaseConstructor::class)
@TypeConverters(DateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun sleepRecordDao(): SleepRecordDao

    companion object {
        const val DATABASE_NAME = "kmp_template.db"
    }
}

expect class AppDatabaseFactory() {
    fun createDatabase(): AppDatabase
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}