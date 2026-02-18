package com.x12q.common_ui.preview_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun PreviewColumnOnSurface(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    PreviewColumn(modifier.background(BaseTheme.colors.baseColors.surface1)) {
        content()
    }
}


