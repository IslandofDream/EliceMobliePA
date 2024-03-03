package com.junwoo.elicemobliepa.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class EliceTypography(
    val homeSectionTitle: TextStyle,
    val homeTitle: TextStyle,
    val homeDescription: TextStyle,
    val homeTag: TextStyle,
    val courseTitleSmall: TextStyle,
    val courseTitleLarge: TextStyle,
    val courseSubTitle: TextStyle,
    val courseButton: TextStyle,
)

val LocalEliceTypography = staticCompositionLocalOf {
    EliceTypography(
        homeSectionTitle = TextStyle.Default,
        homeTitle = TextStyle.Default,
        homeDescription = TextStyle.Default,
        homeTag = TextStyle.Default,
        courseTitleSmall = TextStyle.Default,
        courseTitleLarge = TextStyle.Default,
        courseSubTitle = TextStyle.Default,
        courseButton = TextStyle.Default
    )
}

@Composable
fun getEliceTypography(): EliceTypography =
    EliceTypography(
        homeSectionTitle = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        homeTitle = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 16.sp,
        ),
        homeDescription = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 14.sp,
        ),
        homeTag = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 8.sp,
            lineHeight = 12.sp,
        ),
        courseTitleSmall = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        courseTitleLarge = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 36.sp,
        ),
        courseSubTitle = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
        ),
        courseButton = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        )
    )