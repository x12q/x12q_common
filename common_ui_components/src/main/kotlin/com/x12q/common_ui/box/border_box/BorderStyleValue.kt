package com.x12q.common_ui.box.border_box

import java.util.*

enum class BorderStyleValue {
    __BOT, __TOP, __LEFT, __RIGHT, __NONE;

    companion object {
        val ALL: EnumSet<BorderStyleValue> = EnumSet.of(__BOT, __TOP, __LEFT, __RIGHT)
        val BOT_RIGHT = EnumSet.of(__BOT, __RIGHT)
        val TOP_BOT = EnumSet.of(__TOP, __BOT)
        val TOP_LEFT = EnumSet.of(__TOP, __LEFT)
        val TOP = EnumSet.of(__TOP)
        val BOT = EnumSet.of(__BOT)
        val RIGHT = EnumSet.of(__RIGHT)
        val LEFT = EnumSet.of(__LEFT)
        val LEFT_RIGHT = EnumSet.of(__LEFT, __RIGHT)
        val NONE = EnumSet.of(__NONE)
    }
}
