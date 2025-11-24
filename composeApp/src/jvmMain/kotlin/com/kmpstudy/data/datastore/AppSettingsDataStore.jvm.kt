package com.kmpstudy.data.datastore

import java.io.File

actual fun producePath(fileName: String): String {
    val appDir = File(System.getProperty("user.home"), ".kmptemplate")
    if (!appDir.exists()) {
        appDir.mkdirs()
    }
    val file = File(appDir, fileName)
    return file.absolutePath
}