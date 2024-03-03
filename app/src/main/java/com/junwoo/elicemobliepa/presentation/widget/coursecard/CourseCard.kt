package com.junwoo.elicemobliepa.presentation.widget.coursecard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
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
    val logoFileUrl: String?,
    val title: String,
    val shortDescription: String,
    val tags: List<String>
)


@Composable
fun CourseCard(
    courseCardModel: CourseCardModel,
    onClick: () -> Unit
) {
    val spacer8 = dimensionResource(id = R.dimen.spacer_8)
    val spacer2 = dimensionResource(id = R.dimen.spacer_2)

    Column(
        modifier = Modifier
            .width(200.dp)
            .height(220.dp)
            .clickable { onClick.invoke() }
    ) {

        AsyncImage(
            model = courseCardModel.imageFileUrl ?: courseCardModel.logoFileUrl,
            contentDescription = null,
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(spacer8)
        )
        Text(
            text = courseCardModel.title,
            modifier = Modifier.wrapContentSize(),
            style = EliceTheme.typography.homeTitle
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(spacer2)
        )
        Text(
            text = courseCardModel.shortDescription,
            modifier = Modifier.wrapContentSize(),
            style = EliceTheme.typography.homeDescription
        )
    }
}

@Composable
@Preview(device = Devices.PHONE)
fun PreViewHomeCourseCard(
    @PreviewParameter(CourseCardPreviewProvider::class) courseCardModel: CourseCardModel
) {
    EliceMobliePATheme {
        CourseCard(courseCardModel) {}
    }
}
