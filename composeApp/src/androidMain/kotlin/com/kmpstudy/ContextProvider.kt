package com.kmpstudy

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ContextProvider {
    private var _application: android.app.Application? = null
    val application: android.app.Application
        get() = _application ?: throw IllegalStateException("Application not initialized")

    private var _activity: Context? = null
    val activity: Context
        get() = _activity ?: throw IllegalStateException("Activity Context not initialized")

    fun init(application: Application) {
        _application = application
        // 可以添加初始化逻辑
    }

    fun initActivity(context: Context) {
        _activity = context
    }


    fun cleanup() {
        _application = null
        // 清理资源
    }
}