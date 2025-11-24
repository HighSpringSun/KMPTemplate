package com.kmpstudy.data.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.kmpstudy.ContextProvider
import com.kmpstudy.data.database.AppDatabase.Companion.DATABASE_NAME
import kotlinx.coroutines.Dispatchers

actual class AppDatabaseFactory {

    actual fun createDatabase(): AppDatabase {
        val application = ContextProvider.application
        val dbFile = application.getDatabasePath(DATABASE_NAME)
        return Room
            .databaseBuilder<AppDatabase>(
                context = application,
                name = dbFile.absolutePath,
            ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}