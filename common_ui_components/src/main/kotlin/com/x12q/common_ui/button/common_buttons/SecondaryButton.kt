package com.x12q.common_ui.button.common_buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.x12q.common_ui.button.Button2
import com.x12q.common_ui.button.Button2Colors
import com.x12q.common_ui.theme.LocalCommonColorProvider

/**
 * SecondaryButton is designed to be visually distinct from the primary button (Button2).
 * SecondaryButton is appropriate for actions like `Cancel`, `Close`, or other secondary actions.
 */
@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: Button2Colors = Button2Colors.undefined,
    onClick: () -> Unit
){
    val actualColor = if (colors == Button2Colors.undefined){
        Button2Colors.secondaryButton(
            LocalCommonColorProvider.current.baseColors
        )
    } else {
        colors
    }

    Button2(
        text = text,
        onClick = onClick,
        colors = actualColor,
        modifier = modifier
    )
}
