package com.x12q.common_ui

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun BasicIcon(
    imageVector: ImageVector,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    tint: Color = BaseTheme.colors.baseColors.onPrimary,
) {
    Icon(imageVector, contentDescription, modifier, tint)
}

@Composable
fun BasicIcon(
    painter: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    tint: Color = BaseTheme.colors.baseColors.onPrimary,
) {
    Icon(painter, contentDescription, modifier, tint)
}

@Composable
fun BasicIcon(
    bitmap: ImageBitmap,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    tint: Color = BaseTheme.colors.baseColors.onPrimary,
) {
    Icon(bitmap, contentDescription, modifier, tint)
}
