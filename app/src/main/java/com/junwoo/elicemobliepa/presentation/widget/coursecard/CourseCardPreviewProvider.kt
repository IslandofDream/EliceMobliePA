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
                tags = listOf()
            ),
            CourseCardModel(
                imageFileUrl = TestDummy.TEST_IMAGE,
                logoFileUrl = TestDummy.TEST_LOGO,
                title = "Title",
                shortDescription = "Short Description",
                tags = listOf()
            ),
        )
}