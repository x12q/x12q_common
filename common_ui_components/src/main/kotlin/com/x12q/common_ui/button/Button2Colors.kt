package com.x12q.common_ui.button

import androidx.compose.ui.graphics.Color
import com.x12q.common_ui.theme.BaseColors

data class Button2Colors(
    val backgroundColor: Color,
    val disableBackgroundColor: Color,
    val borderStrokeColor: Color,
    val hoverColor:Color,
) {
    fun background(enabled: Boolean, isHover: Boolean): Color {
        return if(enabled){
            if(isHover){
                hoverColor
            }else{
                backgroundColor
            }
        }else{
            disableBackgroundColor
        }
    }

    companion object {
        fun fromBaseColor(basicColor: BaseColors) = Button2Colors(
            backgroundColor = basicColor.primary,
            borderStrokeColor = basicColor.primary,
            disableBackgroundColor = basicColor.disabled,
            hoverColor = basicColor.primary.copy(alpha=0.5f),
        )

        fun secondaryButton (basicColor: BaseColors)= Button2Colors(
            backgroundColor = basicColor.surface1,
            borderStrokeColor = basicColor.primary,
            disableBackgroundColor = basicColor.disabled,
            hoverColor = basicColor.surface2,
        )

        @Deprecated("z")
        fun default(isDark: Boolean = true): Button2Colors {
            return if(isDark) defaultDark else defaultLight
        }
        @Deprecated("z")
        val defaultLight = fromBaseColor(BaseColors.Light.default)

        @Deprecated("z")
        val defaultDark = fromBaseColor(BaseColors.Dark.default)

        val undefined: Button2Colors  = Button2Colors(
            backgroundColor = Color.Unspecified,
            disableBackgroundColor = Color.Unspecified,
            borderStrokeColor = Color.Unspecified,
            hoverColor = Color.Unspecified,
        )
    }
}



