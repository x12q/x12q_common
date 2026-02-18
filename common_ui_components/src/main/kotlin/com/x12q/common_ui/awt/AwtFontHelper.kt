package com.x12q.common_ui.awt

import java.awt.Font
import java.awt.GraphicsEnvironment


/**
 * Contains helper functions that helps with:
 * - register custom font to awt
 */
object AwtFontHelper {

    val graphicEnv by lazy { GraphicsEnvironment.getLocalGraphicsEnvironment() }


    val allFonts = listOf(
        "JetBrainsMono-Bold.ttf",
        "JetBrainsMono-BoldItalic.ttf",
        "JetBrainsMono-ExtraBold.ttf",
        "JetBrainsMono-ExtraBoldItalic.ttf",
        "JetBrainsMono-ExtraLight.ttf",
        "JetBrainsMono-ExtraLightItalic.ttf",
        "JetBrainsMono-Italic.ttf",
        "JetBrainsMono-Light.ttf",
        "JetBrainsMono-LightItalic.ttf",
        "JetBrainsMono-Medium.ttf",
        "JetBrainsMono-MediumItalic.ttf",
        "JetBrainsMono-Regular.ttf",
        "JetBrainsMono-SemiBold.ttf",
        "JetBrainsMono-SemiBoldItalic.ttf",
        "JetBrainsMono-Thin.ttf",
        "JetBrainsMono-ThinItalic.ttf",

        "JetBrainsMonoNL-Bold.ttf",
        "JetBrainsMonoNL-BoldItalic.ttf",
        "JetBrainsMonoNL-ExtraBold.ttf",
        "JetBrainsMonoNL-ExtraBoldItalic.ttf",
        "JetBrainsMonoNL-ExtraLight.ttf",
        "JetBrainsMonoNL-ExtraLightItalic.ttf",
        "JetBrainsMonoNL-Italic.ttf",
        "JetBrainsMonoNL-Light.ttf",
        "JetBrainsMonoNL-LightItalic.ttf",
        "JetBrainsMonoNL-Medium.ttf",
        "JetBrainsMonoNL-MediumItalic.ttf",
        "JetBrainsMonoNL-Regular.ttf",
        "JetBrainsMonoNL-SemiBold.ttf",
        "JetBrainsMonoNL-SemiBoldItalic.ttf",
        "JetBrainsMonoNL-Thin.ttf",
        "JetBrainsMonoNL-ThinItalic.ttf",
    ).map { "/font/$it" }

    fun registerAllFont() {
        allFonts.forEach { fontResFileName ->
            registerFont(fontResFileName)
        }
    }

    private fun registerFont(resourceFileName: String): Font {
        val resource = this::class.java.getResourceAsStream(resourceFileName)
        val font = Font.createFont(Font.TRUETYPE_FONT, resource)
        graphicEnv.registerFont(font)
        return font
    }

}
