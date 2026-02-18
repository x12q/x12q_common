package com.x12q.common_ui.error_dialog

import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogState
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.rememberDialogState


/**
 * A [Dialog] serve as the underlying dialog for error dialog view only
 */
@Composable
fun BaseErrorDialog(
    dialogState: DialogState = rememberDialogState(
        size = DpSize(400.dp, 220.dp)
    ),
    resizable: Boolean = false,
    undecorated: Boolean = true,
    onDismiss: () -> Unit = {},
    onPreviewKeyEvent: ((KeyEvent) -> Boolean) = { false },
    onKeyEvent: ((KeyEvent) -> Boolean) = { false },
    content: @Composable () -> Unit = {},
) {
    DialogWindow(
        onCloseRequest = onDismiss,
        state = dialogState,
        undecorated = undecorated,
        resizable = resizable,
        onPreviewKeyEvent = onPreviewKeyEvent,
        onKeyEvent = onKeyEvent,
    ) {
        WindowDraggableArea {
            content()
        }
    }
}
