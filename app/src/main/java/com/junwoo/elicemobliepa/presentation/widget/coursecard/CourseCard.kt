package com.junwoo.elicemobliepa.presentation.widget.coursecard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

data class CourseCardModel(
    val imageFileUrl: String?,
    val logoFileUrl: String,
    val title: String,
    val shortDescription: String,
    val tags: List<String>
)

@Composable
fun CourseCard(
    courseCardModel: CourseCardModel, onClick: () -> Unit
) {
    val spacer2 = dimensionResource(id = R.dimen.spacer_2)
    val spacer8 = dimensionResource(id = R.dimen.spacer_8)

    Column(modifier = Modifier
        .width(200.dp)
        .height(220.dp)
        .clickable { onClick.invoke() }) {

        courseCardModel.imageFileUrl?.let { ThumbnailWithImage(it) } ?: ThumbnailWithOutImage(
            courseCardModel.logoFileUrl
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(spacer8)
        )
        Text(
            text = courseCardModel.title,
            modifier = Modifier.fillMaxWidth(),
            style = EliceTheme.typography.homeTitle,
            color = EliceTheme.colors.black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(spacer2)
        )
        Text(
            text = courseCardModel.shortDescription,
            modifier = Modifier.fillMaxWidth(),
            style = EliceTheme.typography.homeDescription,
            color = EliceTheme.colors.darkGray,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(spacer8)
        )
        CourseTagList(tags = courseCardModel.tags)
    }
}

@Composable
private fun ThumbnailWithImage(url: String) {
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp)),
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        error = painterResource(id = R.drawable.ic_launcher_background)
    )
}

@Composable
private fun ThumbnailWithOutImage(url: String) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(EliceTheme.colors.charcoal),
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            modifier = Modifier
                .width(56.dp)
                .height(56.dp)
                .align(Alignment.Center),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background)
        )
    }
}

/*
FlowRow를 활용하여 자동으로 Tag들이 넘어가도록 설정
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CourseTagList(tags: List<String>) {
    FlowRow(
        modifier = Modifier
            .height(35.dp)
            .fillMaxWidth()
            .clip(RectangleShape),
        // Tag의 크기가 고정임을 이용하여 2줄 을 넘어간 높이의 경우 보이지 않게 하도록 설정
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags.forEach { tag ->
            CourseCardTag(content = tag)
        }
    }
}

@Composable
@Preview(device = Devices.PHONE)
private fun PreViewHomeCourseCard(
    @PreviewParameter(CourseCardPreviewProvider::class) courseCardModel: CourseCardModel
) {
    EliceMobliePATheme {
        CourseCard(courseCardModel) {}
    }
}
