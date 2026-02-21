package com.x12q.common_ui

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.*

/**
 * A view that can detect drag event and can change mouse pointer icon when it enters and exits the view.
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DraggableEdge(
    pointerIcon: PointerIcon,
    modifier: Modifier = Modifier,
    onDragged: (dragAmount: Offset) -> Unit
) {

    var isMouseIn: Boolean by remember { mutableStateOf(false) }

    Box(
        modifier
            .pointerHoverIcon(pointerIcon)
            .onPointerEvent(PointerEventType.Enter){
                isMouseIn = true
            }
            .onPointerEvent(PointerEventType.Exit){
                isMouseIn = false
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    onDragged(dragAmount)
                }
            }
    )
}

