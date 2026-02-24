package com.x12q.common_ui.theme

import com.x12q.common_ui.button.Button2Colors
import com.x12q.common_ui.button.IconButton2Colors
import com.x12q.common_ui.drop_down_menu.DropDownButtonItemColors


data class BaseColor(
    val baseColors: BaseColors,
) {
    val buttonColors: Button2Colors = Button2Colors.fromBaseColor(baseColors)
    val iconButtonColors: IconButton2Colors = IconButton2Colors.fromBaseColor(baseColors)
    val dropDownItemColors: DropDownButtonItemColors = DropDownButtonItemColors.fromBaseColor(baseColors)

    companion object Companion {
        val light = BaseColor(
            baseColors = BaseColors.Light.default,
        )

        val dark = BaseColor(
            baseColors = BaseColors.Dark.default,
        )
    }
}
