package com.junwoo.elicemobliepa.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val DarkGray = Color(0xFF242424)
val Charcoal = Color(0xFF3A3A4C)
val Gray = Color(0xFFAEAEAE)
val LightGray = Color(0xFFE4E4E4)
val White = Color(0xFFFFFFFF)

val LightPurple = Color(0xFF524FA1)
val Purple = Color(0xFF5A2ECC)
val CherryRed = Color(0xFFF44336)

data class EliceColors(
    val black: Color,
    val darkGray: Color,
    val charcoal: Color,
    val gray: Color,
    val lightGray: Color,
    val white: Color,
    val lightPurple: Color,
    val purple: Color,
    val cherryRed: Color,
)

val LocalEliceColors = staticCompositionLocalOf {
    EliceColors(
        black = Black,
        darkGray = DarkGray,
        charcoal = Charcoal,
        gray = Gray,
        lightGray = LightGray,
        white = White,
        lightPurple = LightPurple,
        purple = Purple,
        cherryRed = CherryRed
    )
}

val LocalEliceColorScheme = EliceColors(
    black = Black,
    darkGray = DarkGray,
    charcoal = Charcoal,
    gray = Gray,
    lightGray = LightGray,
    white = White,
    lightPurple = LightPurple,
    purple = Purple,
    cherryRed = CherryRed
)

