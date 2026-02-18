package com.x12q.common_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_Bold
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_BoldItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_ExtraBold
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_ExtraBoldItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_ExtraLight
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_ExtraLightItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_Medium
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_MediumItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_Regular
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_SemiBold
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_SemiBoldItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_Thin
import com.x12q.common_ui_components.generated.resources.JetBrainsMonoNL_ThinItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_Bold
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_BoldItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_ExtraBold
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_ExtraBoldItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_ExtraLight
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_ExtraLightItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_Medium
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_MediumItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_Regular
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_SemiBold
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_SemiBoldItalic
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_Thin
import com.x12q.common_ui_components.generated.resources.JetBrainsMono_ThinItalic
import com.x12q.common_ui_components.generated.resources.Res
import org.jetbrains.compose.resources.Font

object CommonTypography {

    val jetBrainMonoFontFamily: FontFamily
        @Composable get() = FontFamily(
            fonts = listOf(
                Font(Res.font.JetBrainsMono_Bold, FontWeight.Bold, FontStyle.Normal),
                Font(Res.font.JetBrainsMono_BoldItalic, FontWeight.Bold, FontStyle.Italic),
                Font(Res.font.JetBrainsMono_ExtraBold, FontWeight.ExtraBold, FontStyle.Normal),
                Font(Res.font.JetBrainsMono_ExtraBoldItalic, FontWeight.ExtraBold, FontStyle.Italic),
                Font(Res.font.JetBrainsMono_ExtraLight, FontWeight.ExtraLight, FontStyle.Normal),
                Font(Res.font.JetBrainsMono_ExtraLightItalic, FontWeight.ExtraLight, FontStyle.Italic),
                Font(Res.font.JetBrainsMono_Medium, FontWeight.Medium, FontStyle.Normal),
                Font(Res.font.JetBrainsMono_MediumItalic, FontWeight.Medium, FontStyle.Italic),
                Font(Res.font.JetBrainsMono_Regular, FontWeight.Normal, FontStyle.Normal),
                Font(Res.font.JetBrainsMono_SemiBold, FontWeight.SemiBold, FontStyle.Normal),
                Font(Res.font.JetBrainsMono_SemiBoldItalic, FontWeight.SemiBold, FontStyle.Italic),
                Font(Res.font.JetBrainsMono_Thin, FontWeight.Thin, FontStyle.Normal),
                Font(Res.font.JetBrainsMono_ThinItalic, FontWeight.Thin, FontStyle.Italic),
            )
        )

    val jetBrainMonoNLFontFamily: FontFamily
        @Composable get() = FontFamily(
            fonts = listOf(
                Font(Res.font.JetBrainsMonoNL_Bold, FontWeight.Bold, FontStyle.Normal),
                Font(Res.font.JetBrainsMonoNL_BoldItalic, FontWeight.Bold, FontStyle.Italic),
                Font(Res.font.JetBrainsMonoNL_ExtraBold, FontWeight.ExtraBold, FontStyle.Normal),
                Font(Res.font.JetBrainsMonoNL_ExtraBoldItalic, FontWeight.ExtraBold, FontStyle.Italic),
                Font(Res.font.JetBrainsMonoNL_ExtraLight, FontWeight.ExtraLight, FontStyle.Normal),
                Font(Res.font.JetBrainsMonoNL_ExtraLightItalic, FontWeight.ExtraLight, FontStyle.Italic),
                Font(Res.font.JetBrainsMonoNL_Medium, FontWeight.Medium, FontStyle.Normal),
                Font(Res.font.JetBrainsMonoNL_MediumItalic, FontWeight.Medium, FontStyle.Italic),
                Font(Res.font.JetBrainsMonoNL_Regular, FontWeight.Normal, FontStyle.Normal),
                Font(Res.font.JetBrainsMonoNL_SemiBold, FontWeight.SemiBold, FontStyle.Normal),
                Font(Res.font.JetBrainsMonoNL_SemiBoldItalic, FontWeight.SemiBold, FontStyle.Italic),
                Font(Res.font.JetBrainsMonoNL_Thin, FontWeight.Thin, FontStyle.Normal),
                Font(Res.font.JetBrainsMonoNL_ThinItalic, FontWeight.Thin, FontStyle.Italic),
            )
        )

    /**
     * This is exclusively for button
     */
    val primaryButtonTextStyle: TextStyle
        @Composable get() = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = jetBrainMonoFontFamily,
            lineHeight = 1.4.sp,
            letterSpacing = 0.1.sp,
            color = BaseTheme.colors.baseColors.onPrimary
        )

    val secondaryButtonTextStyle: TextStyle
        @Composable get() = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Thin,
            fontFamily = jetBrainMonoFontFamily,
            lineHeight = 1.4.sp,
            letterSpacing = 0.1.sp,
            color = BaseTheme.colors.baseColors.onPrimary
        )

    /**
     * Content text is for text describing something. Such as:
     * - Long description
     * - Item in a list
     */
    val content: TextStyle
        @Composable get() = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Thin,
            fontFamily = jetBrainMonoFontFamily,
            letterSpacing = 0.5.sp,
            color = BaseTheme.colors.baseColors.textOnSurface1
        )

    val contentSpanStyle: SpanStyle
        @Composable get() = SpanStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Thin,
            fontFamily = jetBrainMonoFontFamily,
            letterSpacing = 0.5.sp,
            color = BaseTheme.colors.baseColors.textOnSurface1
        )
    val highlightedContentSpanStyle: SpanStyle
        @Composable get() = SpanStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = jetBrainMonoFontFamily,
            letterSpacing = 0.5.sp,
            color = BaseTheme.colors.baseColors.textOnSurface1
        )

    /**
     * Label text is for content that is a bit more pronounce
     */
    val label: TextStyle
        @Composable get() = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Thin,
            fontFamily = jetBrainMonoFontFamily,
            letterSpacing = 0.5.sp,
            color = BaseTheme.colors.baseColors.textOnSurface1
        )
}
