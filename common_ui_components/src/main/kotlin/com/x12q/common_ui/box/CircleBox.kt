package com.x12q.common_ui.box

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.preview_views.PreviewColumn

/**
 * A box whose shape is a circle
 */
@Composable
fun CircleBox(
    modifier: Modifier = Modifier,
    size: Dp = 30.dp,
    color: Color = Color.Unspecified,
    content: @Composable (BoxScope) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(size)
            .then(modifier)
            .clip(CircleShape)
            .background(color),
        content = content,
        contentAlignment = Alignment.Center
    )
}

@Preview
@Composable
private fun Preview_CircleBox() {
    PreviewColumn {
        CircleBox(color = Color.White) {
            Text("abc")
        }

        CircleBox(size = 40.dp, color = Color.Red)
        CircleBox(size = 50.dp, color = Color.Blue)
    }
}
