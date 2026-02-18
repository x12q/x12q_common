package com.x12q.common_ui.button

import androidx.compose.ui.graphics.Color
import com.x12q.common_ui.theme.BaseColors

data class IconButton2Colors(
    val buttonColors: Button2Colors,
    val iconTint: Color,
) {
    companion object {
        fun fromBaseColor(basicColor: BaseColors) = IconButton2Colors(
            buttonColors = Button2Colors.fromBaseColor(basicColor),
            iconTint = basicColor.onPrimary
        )

        val undefined = IconButton2Colors(
            buttonColors = Button2Colors.undefined,
            iconTint = Color.Unspecified,
        )
    }
}
