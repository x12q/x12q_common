package com.x12q.common_ui.text

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.box.BasicContentBox
import com.x12q.common_ui.theme.BaseTheme
import com.x12q.common_ui.corner4Border
import com.x12q.common_ui.preview_views.PreviewColumnOnSurface

/**
 * A standard boxed text, not very useful
 */
@Composable
fun BoxedText(
    text: String,
    textStyle: TextStyle = BaseTheme.typography.content,
    modifier: Modifier = Modifier
) {
    BasicContentBox(
        Modifier
            .background(BaseTheme.colors.baseColors.surface2)
            .padding(horizontal = 8.dp, vertical = 7.dp)
    ) {
        Text(text, modifier = modifier, style = textStyle)
    }
}

@Composable
fun BoxedText(
    text: AnnotatedString,
    textStyle: TextStyle = BaseTheme.typography.content,
    modifier: Modifier = Modifier
) {
    Box(
        Modifier.corner4Border()
            .background(BaseTheme.colors.baseColors.surface1)
            .padding(horizontal = 8.dp, vertical = 7.dp)
    ) {
        Text(text, modifier = modifier, style = textStyle)
    }
}

@Preview
@Composable
private fun Preview_BoxedText() {
    PreviewColumnOnSurface {
        BoxedText("abc abc")
        BoxedText(
            """
            // multi-line text
            fun add(x:Int, y:Int): Int{
                return x + y
            }
        """.trimIndent()
        )
    }
}
