package com.x12q.common_ui.button

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.BasicIcon
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


/**
 * A medium size icon button.
 */
@Composable
fun MediumSizeIconButton(
    icon: DrawableResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TransparentIconButton(
        modifier = modifier.size(25.dp),
        onClick = onClick,
    ) {
        BasicIcon(painterResource(icon))
    }
}
