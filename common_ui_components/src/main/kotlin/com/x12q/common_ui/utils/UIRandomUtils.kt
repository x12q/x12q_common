package com.x12q.common_ui.utils

import androidx.compose.ui.graphics.Color
import com.x12q.common_utils.RandomUtils
import java.util.Random

/**
 * Contains random functions aiding in creating random objects related to UI (such as Color)
 */
object UIRandomUtils {

    private val rand:Random = RandomUtils.rand

    fun randomColor(): Color {
        val r: Float = rand.nextFloat()
        val g: Float = rand.nextFloat()
        val b: Float = rand.nextFloat()
        return Color(r,g,b)
    }
}
