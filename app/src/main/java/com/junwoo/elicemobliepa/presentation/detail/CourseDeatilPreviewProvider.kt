package com.junwoo.elicemobliepa.presentation.detail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.junwoo.elicemobliepa.presentation.util.PreViewDummy

class CourseDeatilPreviewProvider: PreviewParameterProvider<CouresDetailModel> {
    override val values: Sequence<CouresDetailModel>
        get() = sequenceOf(
            CouresDetailModel(
                imageUrl = PreViewDummy.TEST_IMAGE,
                logoUrl = PreViewDummy.TEST_LOGO,
                description = PreViewDummy.TEST_MARKDOWN,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            ),
            CouresDetailModel(
                imageUrl = null,
                logoUrl = PreViewDummy.TEST_LOGO,
                description = PreViewDummy.TEST_MARKDOWN,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            ),
            CouresDetailModel(
                imageUrl = null,
                logoUrl = PreViewDummy.TEST_LOGO,
                description = null,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            )
        )
}