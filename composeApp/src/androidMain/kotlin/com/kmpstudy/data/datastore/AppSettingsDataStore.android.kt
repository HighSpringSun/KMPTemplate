package com.kmpstudy.data.datastore

import com.kmpstudy.ContextProvider

actual fun producePath(fileName: String): String {
    val application = ContextProvider.application
    return application.filesDir.resolve(fileName).absolutePath
}