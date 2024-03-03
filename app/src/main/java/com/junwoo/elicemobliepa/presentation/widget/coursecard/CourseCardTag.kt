package com.junwoo.elicemobliepa.presentation.widget.coursecard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

@Composable
fun CourseCardTag(content: String) {

    val bgColor = EliceTheme.colors.lightGray

    Text(
        text = content, modifier = Modifier
            .drawBehind {
                drawRoundRect(
                    color = bgColor,
                    cornerRadius = CornerRadius(4.dp.toPx())
                )
            }
            .padding(horizontal = 4.dp, vertical = 2.dp),
        style = EliceTheme.typography.homeTag,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
@Preview(device = Devices.PHONE)
fun PreviewCourseCardTag(
    @PreviewParameter(CourseTagPreviewProvider::class) tagList: String
) {
    EliceMobliePATheme {
        CourseCardTag(content = tagList)
    }
}