package com.junwoo.elicemobliepa.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object EliceTheme {
    val colors: EliceColors
        @Composable
        @ReadOnlyComposable
        get() = LocalEliceColors.current

    val typography: EliceTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalEliceTypography.current
}

@Composable
fun EliceMobliePATheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalEliceColors provides LocalEliceColorScheme,
        LocalEliceTypography provides getEliceTypography()
    ) {
        MaterialTheme(content = content)
    }
}