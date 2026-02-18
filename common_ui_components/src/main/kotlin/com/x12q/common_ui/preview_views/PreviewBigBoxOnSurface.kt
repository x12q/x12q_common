package com.x12q.common_ui.preview_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun PreviewBigBoxOnSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.background(BaseTheme.colors.baseColors.surface1).size(400.dp), contentAlignment = Alignment.Center){
        content()
    }
}
