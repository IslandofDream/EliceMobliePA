package com.junwoo.elicemobliepa.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.presentation.util.toSp

data class EliceTypography(
    val homeSectionTitle: TextStyle,
    val homeTitle: TextStyle,
    val homeDescription: TextStyle,
    val homeTag: TextStyle,
    val courseTitleSmall: TextStyle,
    val courseSubTitleSmall: TextStyle,
    val courseTitleLarge: TextStyle,
    val courseSubTitle: TextStyle,
    val courseButton: TextStyle,
    val curriculumTitle: TextStyle,
    val curriculumDescription: TextStyle,
)

val LocalEliceTypography = staticCompositionLocalOf {
    EliceTypography(
        homeSectionTitle = TextStyle.Default,
        homeTitle = TextStyle.Default,
        homeDescription = TextStyle.Default,
        homeTag = TextStyle.Default,
        courseTitleSmall = TextStyle.Default,
        courseSubTitleSmall = TextStyle.Default,
        courseTitleLarge = TextStyle.Default,
        courseSubTitle = TextStyle.Default,
        courseButton = TextStyle.Default,
        curriculumTitle = TextStyle.Default,
        curriculumDescription = TextStyle.Default,
    )
}

@Composable
fun getEliceTypography(): EliceTypography =
    EliceTypography(
        homeSectionTitle = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.dp.toSp(),
            lineHeight = 24.dp.toSp(),
        ),
        homeTitle = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 14.dp.toSp(),
            lineHeight = 16.dp.toSp(),
        ),
        homeDescription = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 10.dp.toSp(),
            lineHeight = 14.dp.toSp(),
        ),
        homeTag = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 8.dp.toSp(),
            lineHeight = 12.dp.toSp(),
        ),
        courseTitleSmall = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.dp.toSp(),
            lineHeight = 24.dp.toSp(),
        ),
        courseSubTitleSmall = TextStyle
            (
            fontFamily = notoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 12.dp.toSp(),
            lineHeight = 20.dp.toSp(),
        ),
        courseTitleLarge = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 28.dp.toSp(),
            lineHeight = 36.dp.toSp(),
        ),
        courseSubTitle = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 14.dp.toSp(),
            lineHeight = 20.dp.toSp(),
        ),
        courseButton = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.dp.toSp(),
            lineHeight = 24.dp.toSp(),
        ),
        curriculumTitle = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 18.dp.toSp(),
            lineHeight = 28.dp.toSp(),
        ),
        curriculumDescription = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 14.dp.toSp(),
            lineHeight = 20.dp.toSp()
        ),
    )