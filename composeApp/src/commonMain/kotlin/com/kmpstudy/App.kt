package com.kmpstudy

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dokar.sonner.rememberToasterState
import com.kmpstudy.di.appModule
import com.kmpstudy.ui.component.toaster.LocalToasterState
import com.slapps.cupertino.theme.CupertinoTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmptemplate.composeapp.generated.resources.Res
import kmptemplate.composeapp.generated.resources.compose_multiplatform
import org.kodein.di.compose.withDI

@Composable
@Preview
fun App() {
    CupertinoTheme {
        withDI(appModule) {
            val globalToasterState = rememberToasterState()
            CompositionLocalProvider(LocalToasterState provides globalToasterState) {

            }
        }
    }
}