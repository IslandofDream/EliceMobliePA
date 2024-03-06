package com.junwoo.elicemobliepa.presentation.detail.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.junwoo.elicemobliepa.presentation.util.PreViewDummy

class CourseDeatilPreviewProvider: PreviewParameterProvider<CouresDetailPreviewModel> {
    override val values: Sequence<CouresDetailPreviewModel>
        get() = sequenceOf(
            CouresDetailPreviewModel(
                imageUrl = PreViewDummy.TEST_IMAGE,
                logoUrl = PreViewDummy.TEST_LOGO,
                description = PreViewDummy.TEST_MARKDOWN,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            ),
            CouresDetailPreviewModel(
                imageUrl = null,
                logoUrl = PreViewDummy.TEST_LOGO,
                description = PreViewDummy.TEST_MARKDOWN,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            ),
            CouresDetailPreviewModel(
                imageUrl = null,
                logoUrl = PreViewDummy.TEST_LOGO,
                description = null,
                lectures = listOf(Pair("첫번째","이야기")),
                title = "title",
                shortDescription = "shortDescription"
            )
        )
}