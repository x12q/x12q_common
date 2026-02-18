package com.x12q.common_ui.preview_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.x12q.common_ui.utils.UIRandomUtils

@Composable
fun PreviewSquare(
    size: DpSize,
    modifier: Modifier = Modifier,
    color: Color? = null,
    content: @Composable BoxScope.()->Unit = {},
) {
    val rColor = color ?: UIRandomUtils.randomColor()
    Box(modifier.size(size).background(rColor), contentAlignment = Alignment.Center ,content = content)
}

@Composable
fun PreviewSquare(
    size: Dp,
    modifier: Modifier = Modifier,
    color: Color? = null,
    content: @Composable BoxScope.()->Unit = {},
) {
    PreviewSquare(
        size = DpSize(size,size), modifier = modifier, color = color, content = content
    )
}
