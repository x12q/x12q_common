package com.x12q.common_ui.preview_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun PreviewBoxOnSurface2(
    modifier: Modifier = Modifier,
    size: DpSize?=null,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = modifier
        .then( if(size!=null) Modifier.size(size) else Modifier)
        .background(BaseTheme.colors.baseColors.surface1),
        contentAlignment = Alignment.Center,
    ){
        content()
    }
}
