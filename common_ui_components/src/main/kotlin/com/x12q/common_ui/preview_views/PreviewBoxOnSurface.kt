package com.x12q.common_ui.preview_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun PreviewBoxOnSurface(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {

    Box(modifier = modifier

        .background(BaseTheme.colors.baseColors.surface1)
        .padding(10.dp)
        ,
        contentAlignment = Alignment.Center,
    ){
        content()
    }
}
