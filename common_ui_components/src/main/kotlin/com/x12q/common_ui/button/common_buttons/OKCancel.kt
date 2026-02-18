package com.x12q.common_ui.button.common_buttons

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.button.Button2
import com.x12q.common_ui.preview_views.PreviewBoxOnSurface
import com.x12q.common_ui.preview_views.PreviewRow
import com.x12q.common_ui.preview_views.previewApp
import com.x12q.common_ui.spacer.HSpacer

/**
 * A panel of 2 buttons: Ok and Cancel
 */
@Composable
fun OKCancel(
    onOK: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        Button2("OK") {
            onOK()
        }

        HSpacer(10.dp)

        SecondaryButton("Cancel") {
            onCancel()
        }
    }
}

@Preview
@Composable
private fun Preview_OkCancel() {
    PreviewBoxOnSurface {
        PreviewRow {
            OKCancel(
                onOK = {},
                onCancel = {}
            )
        }
    }
}

// Checking hover color
private fun main (){
    previewApp {
        Preview_OkCancel()
    }
}