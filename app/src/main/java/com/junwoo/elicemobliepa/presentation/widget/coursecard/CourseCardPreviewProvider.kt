package com.junwoo.elicemobliepa.presentation.widget.coursecard

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.junwoo.elicemobliepa.presentation.util.TestDummy

class CourseCardPreviewProvider : PreviewParameterProvider<CourseCardModel> {
    override val values: Sequence<CourseCardModel>
        get() = sequenceOf(
            CourseCardModel(
                imageFileUrl = null,
                logoFileUrl = TestDummy.TEST_LOGO,
                title = "Title",
                shortDescription = "Short Description",
                tags = listOf("알고리즘", "코딩", "파이썬", "LEVEL1")
            ),
            CourseCardModel(
                imageFileUrl = TestDummy.TEST_IMAGE,
                logoFileUrl = TestDummy.TEST_LOGO,
                title = "Title\nTi\nTT",
                shortDescription = "Short Description\nSh\nS",
                tags = listOf("알고리즘", "코딩", "파이썬", "LEVEL1", "wwwwwwwwwwwwwwwwwwwwwwwww")
            ),
            CourseCardModel(
                imageFileUrl = TestDummy.TEST_IMAGE,
                logoFileUrl = TestDummy.TEST_LOGO,
                title = "Title",
                shortDescription = "Short Description",
                tags = listOf(
                    "알고리즘",
                    "코딩",
                    "파이썬",
                    "LEVEL1",
                    "wwwwwwwwwwwwwwwwwwwwwwwww",
                    "wwwwwwwwwwwwwwwwwwwwwwwww"
                )
            ),
            CourseCardModel(
                imageFileUrl = TestDummy.TEST_IMAGE,
                logoFileUrl = TestDummy.TEST_LOGO,
                title = "Title",
                shortDescription = "Short Description",
                tags = listOf(
                    "알고리즘",
                    "코딩",
                    "파이썬",
                    "LEVEL1",
                    "wwwwwwwwwwwwwwwwwwwwwwwww",
                    "wwwwwwwwwwwwwwwwwwwwwwwww",
                    "wwwwwwwwwwwwwwwwwwwwwwwww"
                )
            ),
        )
}