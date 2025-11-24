package com.kmpstudy.ui.component.toaster

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import com.dokar.sonner.ToastType
import com.dokar.sonner.ToasterState
import com.dokar.sonner.rememberToasterState
import kotlin.time.Duration.Companion.milliseconds


// 定义一个 CompositionLocal 来提供全局访问
val LocalToasterState = staticCompositionLocalOf<ToasterState> {
    error("No ToasterState provided")
}

@Composable
fun globalToasterState(): ToasterState {
    return LocalToasterState.current
}


fun ToasterState.success(message: String) {
    show(message, type = ToastType.Success, duration = 1500.milliseconds)
}

fun ToasterState.error(message: String) {
    show(message, type = ToastType.Error, duration = 2000.milliseconds)
}
