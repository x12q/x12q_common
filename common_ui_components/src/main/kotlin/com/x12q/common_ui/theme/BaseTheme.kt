package com.x12q.common_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf


val LocalCommonColorProvider = staticCompositionLocalOf { CommonColor.dark }

val LocalTypographyProvider = staticCompositionLocalOf { CommonTypography }

val LocalShapesProvider = staticCompositionLocalOf { Shapes }

object BaseTheme{
    val colors: CommonColor @Composable get() = LocalCommonColorProvider.current
    val typography: CommonTypography @Composable get() = LocalTypographyProvider.current
    val shapes: Shapes @Composable get() = LocalShapesProvider.current
}

@Composable
fun BaseTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val color = remember(isDarkTheme){
        if(isDarkTheme){
            CommonColor.dark
        }else{
            CommonColor.light
        }
    }

    CompositionLocalProvider(
        LocalCommonColorProvider provides color,
        LocalTypographyProvider provides CommonTypography,
        LocalShapesProvider provides Shapes,
        content = content
    )
}

