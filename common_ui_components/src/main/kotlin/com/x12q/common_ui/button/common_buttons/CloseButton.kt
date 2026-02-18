package com.x12q.common_ui.button.common_buttons

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.x12q.common_ui.preview_views.PreviewBoxOnSurface
import com.x12q.common_ui.preview_views.PreviewColumn

/**
 * A single "Close" button, should NOT appear as a normal button.
 * Should NOT have a background color like normal button.
 */
@Composable
fun CloseButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SecondaryButton(
        text = "Close",
        onClick = onClick,
        modifier = modifier
    )
}

@Preview
@Composable
private fun Preview_CloseButton(){
    PreviewBoxOnSurface {
        PreviewColumn {
            CloseButton( onClick = {})
        }
    }
}