package com.junwoo.elicemobliepa.presentation.detail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.junwoo.elicemobliepa.presentation.util.TestDummy

class CourseDeatilPreviewProvider: PreviewParameterProvider<CouresDetailModel> {
    override val values: Sequence<CouresDetailModel>
        get() = sequenceOf(
            CouresDetailModel(
                imageUrl = TestDummy.TEST_IMAGE,
                logoUrl = TestDummy.TEST_LOGO,
                description = TestDummy.TEST_MARKDOWN,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            ),
            CouresDetailModel(
                imageUrl = null,
                logoUrl = TestDummy.TEST_LOGO,
                description = TestDummy.TEST_MARKDOWN,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            ),
            CouresDetailModel(
                imageUrl = null,
                logoUrl = TestDummy.TEST_LOGO,
                description = null,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            )
        )
}