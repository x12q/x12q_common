package com.x12q.common_ui.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VSpacer(height:Dp, modifier: Modifier = Modifier) {
    Spacer(
        Modifier.height(height).then(modifier)
    )
}
