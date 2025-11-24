package com.kmpstudy.core.logger

import co.touchlab.kermit.Logger

/**
 * 为每个类自动创建带类名标签的 Logger
 */
inline fun <reified T : Any> T.logger(): Logger =
    Logger.withTag(T::class.simpleName ?: "Unknown")


///**
// * Logger 委托属性
// */
//class LoggerDelegate<T> : kotlin.properties.ReadOnlyProperty<T, Logger> {
//    private var logger: Logger? = null
//
//    override fun getValue(thisRef: T, property: kotlin.reflect.KProperty<*>): Logger {
//        if (thisRef == null) {
//            throw IllegalArgumentException("thisRef cannot be null")
//        }
//        if (logger == null) {
//            val className = thisRef::class.simpleName ?: "Unknown"
//            logger = Logger.withTag(className)
//        }
//        return logger!!
//    }
//}
//
//fun <T> logger(): LoggerDelegate<T> = LoggerDelegate()