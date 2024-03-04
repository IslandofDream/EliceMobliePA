package com.junwoo.elicemobliepa.presentation.widget.topbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

data class EliceTopBarModel(
    val topBarLeftSection: TopBarLeftSection,
    val topBarRightSection: TopBarRightSection,
    val height: Int
)

enum class TopBarLeftSection(
    @DrawableRes val res: Int
) {
    LOGO(R.drawable.image_logo),
    BACK(R.drawable.ic_arrow_back_left)
}

enum class TopBarRightSection(
    @DrawableRes val res: Int?,
) {
    SEARCH(R.drawable.ic_search),
    NONE(null)
}


@Composable
fun EliceTopBar(model: EliceTopBarModel, onLeftClick: () -> Unit, onRightClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(model.height.dp)
            .background(EliceTheme.colors.gray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TopBarLeftSection(topBarLeftSection = model.topBarLeftSection, onClick = onLeftClick)
        TopBarRightSection(topBarRightSection = model.topBarRightSection, onClick = onRightClick)
    }
}

@Composable
private fun TopBarLeftSection(topBarLeftSection: TopBarLeftSection, onClick: () -> Unit) {
    Row {
        when (topBarLeftSection) {
            TopBarLeftSection.LOGO -> {
                Image(
                    painter = painterResource(id = TopBarLeftSection.LOGO.res),
                    contentDescription = null,
                    modifier = Modifier
                        .height(32.dp)
                        .wrapContentWidth()
                )
            }

            TopBarLeftSection.BACK -> {
                Icon(
                    painterResource(id = TopBarLeftSection.BACK.res),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onClick.invoke() }
                )
            }
        }
    }
}

@Composable
private fun TopBarRightSection(topBarRightSection: TopBarRightSection, onClick: () -> Unit) {
    Row {
        when (topBarRightSection) {
            TopBarRightSection.SEARCH -> {
                Icon(
                    painterResource(id = TopBarRightSection.SEARCH.res!!),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { onClick.invoke() }
                )
            }

            TopBarRightSection.NONE -> Unit
        }
    }
}


@Composable
@Preview(device = Devices.PHONE)
fun PreviewTopBar(
    @PreviewParameter(EliceTopBarPreviewProvider::class) models: EliceTopBarModel
) {
    EliceMobliePATheme {
        EliceTopBar(model = models, onLeftClick = {}, onRightClick = {})
    }
}


