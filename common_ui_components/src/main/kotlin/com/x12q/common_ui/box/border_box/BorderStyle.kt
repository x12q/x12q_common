package com.x12q.common_ui.box.border_box

import java.util.*

sealed class BorderStyle(
    val borderStyleValueSet: EnumSet<BorderStyleValue>
) {
    object ALL:BorderStyle(BorderStyleValue.Companion.ALL)
    object BOT_RIGHT :BorderStyle(BorderStyleValue.Companion.BOT_RIGHT)
    object TOP_BOT:BorderStyle(BorderStyleValue.Companion.TOP_BOT)
    object TOP_LEFT:BorderStyle(BorderStyleValue.Companion.TOP_LEFT)
    object TOP: BorderStyle(BorderStyleValue.Companion.TOP)
    object BOT:BorderStyle(BorderStyleValue.Companion.BOT)
    object RIGHT:BorderStyle(BorderStyleValue.Companion.RIGHT)
    object LEFT:BorderStyle(BorderStyleValue.Companion.LEFT)
    object LEFT_RIGHT:BorderStyle(BorderStyleValue.Companion.LEFT_RIGHT)
    object NONE:BorderStyle(BorderStyleValue.Companion.NONE)

    operator fun contains(borderStyleValue: BorderStyleValue):Boolean{
        return borderStyleValue in this.borderStyleValueSet
    }


}
