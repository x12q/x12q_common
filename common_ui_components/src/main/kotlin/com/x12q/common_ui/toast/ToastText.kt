package com.x12q.common_ui.toast

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.x12q.common_ui.text.ContentText
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun ToastText(
    text: String,
    modifier: Modifier = Modifier
) {
    ContentText(
        text = text,
        style = BaseTheme.typography.content.copy(
            color = BaseTheme.colors.baseColors.surface1,
        ),
        modifier = modifier,
    )
}
