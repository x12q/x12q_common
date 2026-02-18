package com.x12q.common_ui.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.x12q.common_ui.theme.BaseTheme

/**
 * A transparent icon button that has two states and can change background based on the state.
 * - switch on
 * - switch off
 *
 */
@Composable
fun SwitchBackgroundTransparentIconButton(
    switch: Boolean,
    switchOnBackground: Color,
    switchOffBackground: Color = Color.Transparent,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (IconButton2Colors) -> Unit,
) {
    IconButton2(
        onClick = onClick,
        modifier = modifier,
        colors = BaseTheme.colors.iconButtonColors.copy(
            buttonColors = BaseTheme.colors.buttonColors.copy(
                backgroundColor = if(switch) switchOnBackground else switchOffBackground,
                borderStrokeColor = Color.Transparent
            )
        ),
    ) { colors ->
        content(colors)
    }
}