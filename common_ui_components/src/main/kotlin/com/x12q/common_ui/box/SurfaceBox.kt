package com.x12q.common_ui.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.x12q.common_ui.theme.BaseTheme

@Deprecated("limit the use of this one, may be removed later")
@Composable
fun SurfaceBox (
    modifier: Modifier = Modifier,
    content:@Composable ()-> Unit,
){
    CenterAlignBox(modifier.fillMaxSize().background(BaseTheme.colors.baseColors.surface1)) {
        content()
    }
}
