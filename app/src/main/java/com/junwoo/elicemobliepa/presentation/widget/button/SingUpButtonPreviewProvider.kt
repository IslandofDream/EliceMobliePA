package com.junwoo.elicemobliepa.presentation.widget.button

import androidx.compose.runtime.Composable
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.ui.theme.EliceTheme

@Composable
fun getSingUpButtonModels(): Sequence<SignUpButtonModel> = sequenceOf(
    SignUpButtonModel(
        enrollText = R.string.button_enroll,
        enrollColor = EliceTheme.colors.purple,
        withdrawalText = R.string.button_withdrawal,
        withdrawalColor = EliceTheme.colors.cherryRed,
        textColor = EliceTheme.colors.white
    ),
    SignUpButtonModel(
        enrollText = R.string.button_long_text,
        enrollColor = EliceTheme.colors.purple,
        withdrawalText = R.string.button_long_text,
        withdrawalColor = EliceTheme.colors.cherryRed,
        textColor = EliceTheme.colors.white
    ),
)
