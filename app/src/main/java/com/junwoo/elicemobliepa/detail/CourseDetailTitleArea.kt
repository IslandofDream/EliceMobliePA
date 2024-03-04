package com.junwoo.elicemobliepa.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.presentation.util.TestDummy
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

@Composable
fun TitleAreaWithoutImage(logoUrl: String, title: String, shortDescription: String) { //
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        AsyncImage(
            model = logoUrl,
            contentDescription = null,
            modifier = Modifier
                .width(56.dp)
                .height(56.dp),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background)
        )
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
            style = EliceTheme.typography.courseShortDescription,
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
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            AsyncImage(
                model = logoUrl,
                contentDescription = null,
                modifier = Modifier
                    .width(36.dp)
                    .height(36.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background)
            )
            Spacer(
                modifier = Modifier
                    .height(36.dp)
                    .width(8.dp)
            )
            Text(
                text = title,
                style = EliceTheme.typography.courseTitleSmall,
                color = EliceTheme.colors.black
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
        )
    }
}

@Preview
@Composable
private fun PreviewTitleAreaWithoutImage() {
    EliceMobliePATheme {
        TitleAreaWithoutImage(
            logoUrl = TestDummy.TEST_LOGO,
            title = "title",
            shortDescription = "Description"
        )
    }
}

@Preview
@Composable
private fun PreviewTitleAreaWithImage() {
    EliceMobliePATheme {
        TitleAreaWithImage(
            logoUrl = TestDummy.TEST_LOGO,
            imageUrl = TestDummy.TEST_IMAGE,
            title = "title"
        )
    }
}


