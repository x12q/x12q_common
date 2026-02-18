package com.x12q.common_ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun TransparentIconButton(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
) {
    IconButton2(
        onClick = onClick,
        modifier = modifier,
        colors = BaseTheme.colors.iconButtonColors.copy(
            buttonColors = BaseTheme.colors.buttonColors.copy(
                backgroundColor = Color.Transparent,
                borderStrokeColor = Color.Transparent
            )
        ).apply {
            if(tint!=null){
                this.copy(iconTint = tint)
            }else{
                this
            }
        },
        contentPadding = contentPadding,
    ) { colors ->
        Icon(
            painter = icon, "",
            tint = colors.iconTint,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun TransparentIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
    content: @Composable (IconButton2Colors) -> Unit,
) {
    IconButton2(
        onClick = onClick,
        modifier = modifier,
        colors = BaseTheme.colors.iconButtonColors.copy(
            buttonColors = BaseTheme.colors.buttonColors.copy(
                backgroundColor = Color.Transparent,
                borderStrokeColor = Color.Transparent,
            )
        ),
        contentPadding = contentPadding,
    ) { colors ->
        content(colors)
    }
}

