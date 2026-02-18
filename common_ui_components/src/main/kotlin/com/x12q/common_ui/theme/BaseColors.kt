package com.x12q.common_ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Base colors are colors defined by their role in the most basic aspects of views, and they are not tied to any specific views.
 * For example:
 * - surface color
 * - color of text on a surface.
 * Surface can be anything ranging from a surface of a button to a surface of a tab or a text view.
 *
 * Colors tailored to specific view (such as button color) can be based on base colors for consistency.
 */
data class BaseColors(
    val primary: Color,
    val primaryVariant: Color,
    val onPrimary: Color,
    /**
     * a surface color
     */
    val surface1: Color,
    val textHintOnSurface1: Color,
    val textOnSurface1: Color,
    val strongOnSurface1: Color,
    val borderOnSurface1: Color,
    val faintOnSurface1: Color,

    /**
     * [surface2] is darker than [surface1]
     */
    val surface2: Color,
    val onSurface2: Color,
    val textOnSurface2: Color,
    val faintOnSurface2: Color,

    val disabled: Color,
) {

    object Light {
        val light2 = BaseColors(
            primary = Color(0xFFFFA726),
            primaryVariant = Color(0xFFFF7043),
            surface2 = Color(0xFFFFFFFF),
            surface1 = Color(0xFFF6F8FA),
            onPrimary = Color(0xFF212121),
            onSurface2 = Color(0xFF1F1F1F),
            strongOnSurface1 = Color(0xFF1F1F1F),
            textOnSurface1 = Color(0xFF1F1F1F),
            textHintOnSurface1 = Color(0xFF888888),
            disabled = Color.LightGray,
            faintOnSurface2 = Color(0xFFB0B0B0),
            textOnSurface2 = Color(0xFF3A3A3C),
            borderOnSurface1 = Color(0xFFFFFFFF),
            faintOnSurface1 = Color(0xFFB0B0B0),
        )


        val default = light2
    }

    object Dark {
        // this one mimic the dark color theme of intellij idea
        val DarkGrayShade = BaseColors(
            primary = Color(0xFF1F6FEB),
            primaryVariant = Color(0xFF58A6FF),
            surface2 = Color(0xFF1e1e1e),
            surface1 = Color(0xFF2b2d30),
            onPrimary = Color(0xFFC9D1D9),
            onSurface2 = Color(0xFFC9D1D9),
            strongOnSurface1 = Color(0xFFC9D1D9),
            textOnSurface1 = Color(0xFFf0f0f0),
            textOnSurface2 = Color(0xFFDCDCDC),
            textHintOnSurface1 = Color(0xFF444444),
            disabled = Color.Gray,
            faintOnSurface2 = Color(0xFF3A3A3C),
            borderOnSurface1 = Color(0xFF1e1e1e),
            faintOnSurface1 = Color(0xFF545457),
        )

        val default = DarkGrayShade
    }
}
