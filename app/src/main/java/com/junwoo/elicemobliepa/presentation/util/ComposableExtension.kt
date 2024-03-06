package com.junwoo.elicemobliepa.presentation.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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

@Composable
fun RowScope.Spacer(length: Dp) {
    androidx.compose.foundation.layout.Spacer(
        modifier = Modifier.width(length)
    )
}

@Composable
fun ColumnScope.Spacer(length: Dp) {
    androidx.compose.foundation.layout.Spacer(
        modifier = Modifier.height(length)
    )
}

@Composable
fun ColumnScope.Spacer2() = Spacer(2.dp)

@Composable
fun ColumnScope.Spacer4() = Spacer(4.dp)

@Composable
fun ColumnScope.Spacer8() = Spacer(8.dp)

@Composable
fun ColumnScope.Spacer16() = Spacer(16.dp)

@Composable
fun RowScope.Spacer2() = Spacer(2.dp)

@Composable
fun RowScope.Spacer4() = Spacer(4.dp)

@Composable
fun RowScope.Spacer8() = Spacer(8.dp)

@Composable
fun RowScope.Spacer16() = Spacer(16.dp)