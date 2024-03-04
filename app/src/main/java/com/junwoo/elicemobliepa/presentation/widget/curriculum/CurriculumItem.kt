import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.presentation.widget.curriculum.CurriculumPreviewProvider
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

@Composable
fun CurriculumItem(items: List<Pair<String, String>>) {

    Box(modifier = Modifier.fillMaxSize()) {
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

@Composable
fun TimelineView(
    title: String,
    description: String,
    index: Int,
    itemCount: Int,
) {
    var height by remember { mutableStateOf(0) }

    val circleSize = 16.dp
    val timeLineColor = EliceTheme.colors.purple
    val lineWidth = 2.dp
    val spaceBetweenCircleAndLine = 16.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .onSizeChanged { size ->
                height = size.height
            }
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(start = circleSize + spaceBetweenCircleAndLine)
        ) {
            Column {
                Text(text = title, style = EliceTheme.typography.curriculumTitle)
                Text(text = description, style = EliceTheme.typography.courseSubTitle)
            }
        }

        // 원과 선을 그릴 Canvas
        Canvas(modifier = Modifier.align(Alignment.TopStart)) {
            val circleRadius = circleSize.toPx() / 2
            val lineStart = Offset(circleRadius, circleRadius * 2)
            val lineEnd = Offset(circleRadius, height.toFloat())

            // 선 그리기
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
                center = Offset(circleRadius, circleRadius),
                style = Stroke(width = 2.0F)
            )
        }
    }
}

@Preview(device = Devices.PHONE)
@Composable
fun DefaultPreview(
    @PreviewParameter(CurriculumPreviewProvider::class) curriculums: List<Pair<String, String>>
) {
    EliceMobliePATheme {
        CurriculumItem(items = curriculums)
    }
}