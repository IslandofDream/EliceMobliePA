package com.junwoo.elicemobliepa.presentation.widget.button

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

data class SignUpButtonModel(
    @StringRes val enrollText: Int,
    val enrollColor: Color,
    val withdrawalColor: Color,
    @StringRes val withdrawalText: Int,
    val textColor: Color,
)

@Composable
fun SignUpButton(model: SignUpButtonModel, applied: Boolean, onClick: () -> Unit) {
    val applied by remember {
        mutableStateOf(applied)
    }

    val bgColor = if (applied) model.withdrawalColor else model.enrollColor
    val text =
        if (applied) stringResource(id = model.withdrawalText) else stringResource(id = model.enrollText)

    Button(
        onClick = onClick,
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = model.textColor,
        )
    ) {
        Text(
            text = text,
            style = EliceTheme.typography.courseButton,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)
        )
    }
}

@Composable
@Preview(device = Devices.PHONE)
fun SignUpButtonPreview() {
    EliceMobliePATheme {
        Column(
            modifier = Modifier.background(Color.Gray),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            getSingUpButtonModels().forEach { model ->
                SignUpButton(model = model, true) {}
                SignUpButton(model = model, false) {}
            }
        }
    }
}