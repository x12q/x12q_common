package com.x12q.common_ui.awt

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

fun Color.toAwtColor(): java.awt.Color {
    return java.awt.Color(red, green, blue, alpha)
}
