package com.junwoo.elicemobliepa.presentation.widget.topbar

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class EliceTopBarPreviewProvider : PreviewParameterProvider<EliceTopBarModel> {
    override val values: Sequence<EliceTopBarModel>
        get() = sequenceOf(
            EliceTopBarModel(
                topBarLeftSection = TopBarLeftSection.LOGO,
                topBarRightSection = TopBarRightSection.SEARCH,
                height = 64
            ),
            EliceTopBarModel(
                topBarLeftSection = TopBarLeftSection.BACK,
                topBarRightSection = TopBarRightSection.NONE,
                height = 56
            )
        )
}