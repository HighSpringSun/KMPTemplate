package com.kmpstudy.data.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlin.time.Instant


@Serializable
data class AppSettings(
    val isFirstLaunch: Boolean = true,
    val isLoggedIn: Boolean = false,
    val deviceKey: String? = null,
    val userName: String? = null,
    val userEmail: String? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null,
//    val currentUser: User? = null,
    val themePreference: String = "system",
    val notificationEnabled: Boolean = true,
//    @Contextual
//    val lastSyncedAt: Instant? = null // 最后同步时间戳，用于增量同步
)
