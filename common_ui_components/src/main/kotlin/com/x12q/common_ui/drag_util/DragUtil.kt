package com.x12q.common_ui.drag_util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect

fun makeRectForMouseDrag(
    anchor: Offset,
    movingPoint: Offset
): Rect {
    // more to the upper side -> smaller number
    // more to the left side -> smaller number
    val movingPointIsAbove = movingPoint.y < anchor.y
    val movingPointIsLeft = movingPoint.x < anchor.x

    val topLeft = if (movingPointIsAbove) {
        if (movingPointIsLeft) {
            movingPoint
        } else {
            Offset(x = anchor.x, y = movingPoint.y)
        }
    } else {
        if (movingPointIsLeft) {
            Offset(x = movingPoint.x, y = anchor.y)
        } else {
            anchor
        }
    }

    val botRight = if (movingPointIsAbove) {
        if (movingPointIsLeft) {
            anchor
        } else {
            Offset(x = movingPoint.x, y = anchor.y)
        }
    } else {
        if (movingPointIsLeft) {
            Offset(x = anchor.x, y = movingPoint.y)
        } else {
            movingPoint
        }
    }
    return Rect(topLeft, botRight)
}
