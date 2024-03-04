package com.junwoo.elicemobliepa.presentation.widget.curriculum

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

@Composable
fun TimelineView(
    title: String,
    description: String,
    index: Int,
    itemCount: Int,
) {
    // 제목, Description에 따른 높이 변화를 저장하는 함수
    var height by remember { mutableStateOf(0) }

    val spacer4 = dimensionResource(id = R.dimen.spacer_4)
    val spacer8 = dimensionResource(id = R.dimen.spacer_8)

    val circleSize = 16.dp
    val lineWidth = 2.dp
    val timeLineColor = EliceTheme.colors.purple
    val spaceBetweenTimeLineAndText = 8.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .onSizeChanged { size ->
                height = size.height
            }
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(start = circleSize + spaceBetweenTimeLineAndText)
        ) {
            Column {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(spacer8)
                )
                Text(
                    text = title, style = EliceTheme.typography.curriculumTitle,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(spacer4)
                )
                Text(text = description, style = EliceTheme.typography.curriculumDescription)
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(spacer8)
                )
            }
        }

        // TimeLine을 위한 원과 선을 그릴 Canvas
        Canvas(modifier = Modifier.align(Alignment.TopStart)) {
            val circleRadius = circleSize.toPx() / 2
            val spaceWithTopAndCircle = 14.dp.toPx()
            val lineStart = Offset(circleRadius, (circleRadius * 2) + spaceWithTopAndCircle)
            val lineEnd = Offset(circleRadius, height.toFloat() + spaceWithTopAndCircle)

            // 선 그리기
            // 마지막 원의 경우 선을 그리지 않음
            if (index < itemCount - 1) {
                drawLine(
                    color = timeLineColor,
                    start = lineStart,
                    end = lineEnd,
                    strokeWidth = lineWidth.toPx()
                )
            }
            // 원 그리기
            drawCircle(
                color = timeLineColor,
                radius = circleRadius,
                center = Offset(circleRadius, circleRadius + spaceWithTopAndCircle),
                style = Stroke(width = 2.0F)
            )
        }
    }
}

@Composable
private fun CurriculumItem(items: List<Pair<String, String>>) {

    Box {
        LazyColumn(modifier = Modifier.matchParentSize()) {
            itemsIndexed(items) { index, item ->
                TimelineView(
                    title = item.first,
                    description = item.second,
                    index = index,
                    itemCount = items.size,
                )
            }
        }
    }
}

@Preview(device = Devices.PHONE)
@Composable
private fun CurriculumPreview(
    @PreviewParameter(CurriculumPreviewProvider::class) curriculums: List<Pair<String, String>>
) {
    EliceMobliePATheme {
        CurriculumItem(items = curriculums)
    }
}