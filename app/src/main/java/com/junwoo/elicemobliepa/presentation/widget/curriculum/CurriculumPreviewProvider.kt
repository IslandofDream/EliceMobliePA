package com.junwoo.elicemobliepa.presentation.widget.curriculum

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CurriculumPreviewProvider : PreviewParameterProvider<List<TimeLineModel>> {
    override val values: Sequence<List<TimeLineModel>>
        get() = sequenceOf(
            listOf(
                TimeLineModel(
                    title = "첫 번째 이야기",
                    description = "엘리스 토끼",
                    index = 1,
                    itemCount = 1
                )
            ),
            listOf(
                TimeLineModel(
                    title = "첫 번째 이야기",
                    description = "엘리스 토끼",
                    index = 1,
                    itemCount = 6
                ),
                TimeLineModel(
                    title = "첫 번째 이야기",
                    description = "짧은 설명",
                    index = 2,
                    itemCount = 6
                ),
                TimeLineModel(
                    title = "첫 번째 이야기",
                    description = "짧지만 두줄\n 설명",
                    index = 3,
                    itemCount = 6
                ),
                TimeLineModel(
                    title = "첫 번째 이야기",
                    description = "긴 설명 \n\n\n\n\n\n\n\n\n",
                    index = 4,
                    itemCount = 6
                ), TimeLineModel(
                    title = "첫 번째 이야기",
                    description = "엘리스 토끼",
                    index = 5,
                    itemCount = 6
                ), TimeLineModel(
                    title = "첫 번째 이야기",
                    description = "엘리스 토끼",
                    index = 6,
                    itemCount = 6
                )
            )
        )

}