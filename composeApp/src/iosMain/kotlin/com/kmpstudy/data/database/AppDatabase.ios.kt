package com.kmpstudy.data.database

import androidx.room.Room
import com.kmpstudy.core.Constant
import com.kmpstudy.data.database.AppDatabase.Companion.DATABASE_NAME
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual class AppDatabaseFactory {
    actual fun createDatabase(): AppDatabase {
        val dbFile = "${getSharedDatabaseDirectory()}/${DATABASE_NAME}"
        return Room
            .databaseBuilder<AppDatabase>(
                name = dbFile,
            ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun getSharedDatabaseDirectory(): String {
        // 使用 App Groups 共享容器
        val groupContainer: NSURL? = NSFileManager.defaultManager
            .containerURLForSecurityApplicationGroupIdentifier(Constant.GROUP_IDENTIFIER)

        requireNotNull(groupContainer) { "无法访问 App Group 容器" }
        return groupContainer.path!!
    }


    @OptIn(ExperimentalForeignApi::class)
    private fun fileDirectory(): String {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory).path!!
    }
}