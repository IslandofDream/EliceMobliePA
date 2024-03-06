package com.junwoo.elicemobliepa.presentation.widget.loading

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CircularLoadingPreviewProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = sequenceOf(
            220, 64
        )
}