package com.junwoo.elicemobliepa.presentation.widget.curriculum

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CurriculumPreviewProvider : PreviewParameterProvider<List<Pair<String, String>>> {
    override val values: Sequence<List<Pair<String, String>>>
        get() = sequenceOf(
            listOf(
                Pair("첫 번째 이야기", "dkdkdkkdkdkdkd"),
            ),
            listOf(
                Pair("첫 번째 이야기", "dkdkdkkdkdkdkd"),
                Pair("두 번째 이야기", "짧은 설명"),
                Pair("세 번째 이야기", "짧지만 두줄\n 설명"),
                Pair("네 번째 이야기\n", "안녕\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"),
                Pair("다섯번째 이야기", "그래")
            ),
        )
}