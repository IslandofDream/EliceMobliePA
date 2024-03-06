package com.junwoo.elicemobliepa.presentation.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp

/*
    리플영역을 자연스럽게 변경해주는 확장함수
 */
@Composable
fun Modifier.rippleClickable(
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    role: Role? = null,
    onClick: () -> Unit,
) =
    composed {
        this.clickable(
            interactionSource = interactionSource,
            indication = rememberRipple(bounded = false),
            enabled = enabled,
            role = role,
            onClick = onClick,
        )
    }

@Composable
fun Dp.toSp() = with(LocalDensity.current) { this@toSp.toSp() }
