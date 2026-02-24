package com.x12q.common_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf


val LocalBaseColorProvider = staticCompositionLocalOf { BaseColor.dark }
val LocalBaseTypographyProvider = staticCompositionLocalOf { BaseTypography }
val LocalBaseShapesProvider = staticCompositionLocalOf { BaseShapes }

object BaseTheme{
    val colors: BaseColor @Composable get() = LocalBaseColorProvider.current
    val typography: BaseTypography @Composable get() = LocalBaseTypographyProvider.current
    val shapes: BaseShapes @Composable get() = LocalBaseShapesProvider.current
}

@Composable
fun BaseTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val color = remember(isDarkTheme){
        if(isDarkTheme){
            BaseColor.dark
        }else{
            BaseColor.light
        }
    }

    CompositionLocalProvider(
        LocalBaseColorProvider provides color,
        LocalBaseTypographyProvider provides BaseTypography,
        LocalBaseShapesProvider provides BaseShapes,
        content = content
    )
}

