package com.x12q.common_ui.drop_down_menu

import androidx.compose.ui.graphics.Color
import com.x12q.common_ui.theme.BaseColors

data class DropDownButtonItemColors(
    val textEnabledColor: Color,
    val textDisabledColor: Color,
){
    companion object{

        fun fromBaseColor(basic: BaseColors):DropDownButtonItemColors{
            return DropDownButtonItemColors(
                textEnabledColor = basic.strongOnSurface1,
                textDisabledColor = basic.faintOnSurface2
            )
        }
    }
}
