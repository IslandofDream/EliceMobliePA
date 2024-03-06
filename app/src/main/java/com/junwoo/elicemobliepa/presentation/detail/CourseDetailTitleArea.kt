package com.junwoo.elicemobliepa.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.presentation.util.PreViewDummy
import com.junwoo.elicemobliepa.ui.theme.EliceMobilePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

@Composable
fun TitleAreaWithoutImage(logoUrl: String, title: String, shortDescription: String) { //
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        LogoWithCard(size = 56, logoUrl = logoUrl)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        Text(
            text = title,
            style = EliceTheme.typography.courseTitleLarge,
            color = EliceTheme.colors.black
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        Text(
            text = shortDescription,
            style = EliceTheme.typography.courseSubTitleSmall,
            color = EliceTheme.colors.black
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
    }
}

@Composable
fun TitleAreaWithImage(
    logoUrl: String,
    imageUrl: String,
    title: String
) { // 하단에 2*1 의 이미지 있음
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoWithCard(size = 36, logoUrl = logoUrl)
            Spacer(
                modifier = Modifier
                    .height(36.dp)
                    .width(8.dp)
            )
            Text(
                text = title,
                style = EliceTheme.typography.courseTitleSmall,
                color = EliceTheme.colors.black,
            )
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f),
            placeholder = painterResource(id = R.drawable.image_placeholder_aspect_ratio_24),
            error = painterResource(id = R.drawable.image_error)
        )
    }
}

@Composable
private fun LogoWithCard(size: Int, logoUrl: String) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(EliceTheme.colors.whiteGray),
    ) {
        AsyncImage(
            model = logoUrl,
            contentDescription = null,
            modifier = Modifier
                .size(size.dp),
            placeholder = painterResource(id = R.drawable.image_placeholder_logo),
            error = painterResource(id = R.drawable.image_error)
        )
    }

}

@Preview
@Composable
private fun PreviewTitleAreaWithoutImage() {
    EliceMobilePATheme {
        TitleAreaWithoutImage(
            logoUrl = PreViewDummy.TEST_LOGO,
            title = "title",
            shortDescription = "Description"
        )
    }
}

@Preview
@Composable
private fun PreviewTitleAreaWithImage() {
    EliceMobilePATheme {
        TitleAreaWithImage(
            logoUrl = PreViewDummy.TEST_LOGO,
            imageUrl = PreViewDummy.TEST_IMAGE,
            title = "title"
        )
    }
}


