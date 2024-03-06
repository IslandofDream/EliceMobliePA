package com.junwoo.elicemobliepa.presentation.widget.loading

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.ui.theme.EliceMobilePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

@Composable
fun CircularLoading(height: Int) {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
            .wrapContentSize(Alignment.Center),
        color = EliceTheme.colors.lightGray,
    )
}

@Composable
@Preview(device = Devices.PHONE)
private fun CircularLoadingPreview(
    @PreviewParameter(CircularLoadingPreviewProvider::class) height: Int
) {
    EliceMobilePATheme {
        CircularLoading(height = height)
    }
}