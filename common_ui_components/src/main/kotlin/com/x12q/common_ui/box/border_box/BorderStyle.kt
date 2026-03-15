package com.x12q.common_ui.box.border_box

import java.util.*

sealed class BorderStyle(
    val borderStyleValueSet: EnumSet<BorderStyleValue>
) {
    object ALL:BorderStyle(BorderStyleValue.ALL)
    object BOT_RIGHT :BorderStyle(BorderStyleValue.BOT_RIGHT)
    object TOP_BOT:BorderStyle(BorderStyleValue.TOP_BOT)
    object TOP_LEFT:BorderStyle(BorderStyleValue.TOP_LEFT)
    object TOP: BorderStyle(BorderStyleValue.TOP)
    object BOT:BorderStyle(BorderStyleValue.BOT)
    object RIGHT:BorderStyle(BorderStyleValue.RIGHT)
    object LEFT:BorderStyle(BorderStyleValue.LEFT)
    object LEFT_RIGHT:BorderStyle(BorderStyleValue.LEFT_RIGHT)
    object NONE:BorderStyle(BorderStyleValue.NONE)

    operator fun contains(borderStyleValue: BorderStyleValue):Boolean{
        return borderStyleValue in this.borderStyleValueSet
    }


}
