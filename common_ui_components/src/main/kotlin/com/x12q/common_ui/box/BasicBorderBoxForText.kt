package com.x12q.common_ui.box

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.corner4Border

/**
 * A basic box with predefined padding + border, for holding content
 */
@Composable
fun BasicBorderContentBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    BasicContentBox(
        modifier = modifier,
        border = Modifier.Companion.corner4Border(),
        content = content,
    )
}

/**
 * A basic box with predefined padding, for holding content
 */
@Composable
fun BasicContentBox(
    modifier: Modifier = Modifier,
    border: Modifier? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier.then(border ?: Modifier).padding(horizontal = 8.dp, vertical = 7.dp)
    ) {
        content()
    }
}



