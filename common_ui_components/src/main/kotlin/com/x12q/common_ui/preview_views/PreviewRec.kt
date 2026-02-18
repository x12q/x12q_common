package com.x12q.common_ui.preview_views

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize

@Composable
fun PreviewRec(
    height: Dp,
    width:Dp,
    modifier: Modifier = Modifier,
    color: Color? = null,
    content: @Composable BoxScope.()->Unit = {},
) {
    PreviewSquare(
        size = DpSize(width, height),
        modifier = modifier,
        color = color,
        content = content
    )
}
