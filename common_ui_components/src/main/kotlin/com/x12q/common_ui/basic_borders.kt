package com.x12q.common_ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.box.CenterAlignBox
import com.x12q.common_ui.theme.*

@Composable
fun Modifier.corner8Border(
    width: Dp = 1.dp,
    color: Color = BaseTheme.colors.baseColors.faintOnSurface2,
): Modifier {
    val shape: Shape = BaseTheme.shapes.corner8
    return this.cornerXBorder(width,color,shape)
}

@Composable
fun Modifier.corner4Border(
    width: Dp = 1.dp,
    color: Color = BaseTheme.colors.baseColors.faintOnSurface2,
): Modifier {
    val shape: Shape = BaseTheme.shapes.corner4
    return this.cornerXBorder(width,color,shape)
}

@Composable
fun Modifier.corner6Border(
    width: Dp = 1.dp,
    color: Color = BaseTheme.colors.baseColors.faintOnSurface2,
): Modifier {
    val shape: Shape = BaseTheme.shapes.corner6
    return this.cornerXBorder(width,color,shape)
}

@Composable
fun Modifier.corner3Border(
    width: Dp = 1.dp,
    color: Color = BaseTheme.colors.baseColors.faintOnSurface2,
): Modifier {
    val shape: Shape = BaseTheme.shapes.corner3
    return this.cornerXBorder(width,color,shape)
}

@Composable
fun Modifier.corner12Border(
    width: Dp = 1.dp,
    color: Color = BaseTheme.colors.baseColors.faintOnSurface2,
): Modifier {
    val shape: Shape = BaseTheme.shapes.corner12
    return this.cornerXBorder(width,color,shape)
}

@Composable
fun Modifier.cornerXBorder(
    width: Dp = 1.dp,
    color: Color = BaseTheme.colors.baseColors.faintOnSurface2,
    shape: Shape,
): Modifier {
    return this
        .clip(shape)
        .border(width, color, shape)
}


@Preview
@Composable
fun Preview_borders() {
    CenterAlignBox(Modifier.fillMaxSize().background(BaseTheme.colors.baseColors.surface1)) {
        CenterAlignBox(
            Modifier
                .corner4Border().size(500.dp)
        ) {
            CenterAlignBox(
                Modifier.corner8Border()
                    .size(250.dp)
            ) {
                CenterAlignBox(
                    Modifier

                        .corner12Border().size(200.dp)
                ) {

                }
            }
        }
    }
}
