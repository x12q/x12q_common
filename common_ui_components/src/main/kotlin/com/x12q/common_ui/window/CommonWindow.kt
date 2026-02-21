package com.x12q.common_ui.window

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.jewel.intui.window.styling.dark
import org.jetbrains.jewel.intui.window.styling.light
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.DecoratedWindowScope
import org.jetbrains.jewel.window.TitleBar
import org.jetbrains.jewel.window.TitleBarScope
import org.jetbrains.jewel.window.newFullscreenControls
import org.jetbrains.jewel.window.styling.DecoratedWindowStyle
import org.jetbrains.jewel.window.styling.LocalDecoratedWindowStyle
import org.jetbrains.jewel.window.styling.LocalTitleBarStyle
import org.jetbrains.jewel.window.styling.TitleBarStyle
import org.jetbrains.jewel.window.utils.DesktopPlatform

/**
 * a preconfig wrapper for [TitleBar]
 */
@Composable
fun DecoratedWindowScope.TitleBarView(
    modifier: Modifier = Modifier,
    style: TitleBarStyle,
    content: @Composable TitleBarScope.() -> Unit,
) {
    TitleBar(
        // This allows the window controller buttons to show up as
        // part of the screen when the app goes into full-screen mode.
        modifier = modifier.newFullscreenControls(),
        style = style,
    ) {
        val horizontalPadding = when (DesktopPlatform.Current) {
            DesktopPlatform.MacOS -> 40.dp
            else -> 0.dp
        }
        Box(
            /**
             * This modifier is a work-around for an ongoing bug.
             *
             * The bug:
             * - When the content of the top bar stretches too long (such as a scrollable row with a large number of items),
             *      -> the content will clip into the 3-buttons window controller on Mac
             *
             * The work-around:
             * - stretch the content to the max size.
             * - then a fix padding to lock everything in place.
             */
            modifier = Modifier
                .align(Alignment.Start)
                .fillMaxWidth().fillMaxHeight().padding(horizontal = horizontalPadding)
        ) {
            content()
        }
    }
}

/**
 * A convenient wrapper of jewel title bar and decorated window.
 */
@Composable
fun CommonWindow(
    onCloseRequest: () -> Unit,
    state: WindowState = rememberWindowState(),
    isDarkTheme: Boolean = true,
    visible: Boolean = true,
    title: String = "",
    icon: Painter? = null,
    resizable: Boolean = true,
    enabled: Boolean = true,
    focusable: Boolean = true,
    alwaysOnTop: Boolean = false,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    titleBarContent: @Composable TitleBarScope.() -> Unit,
    content: @Composable DecoratedWindowScope.() -> Unit,
) {
    CompositionLocalProvider(
        LocalDecoratedWindowStyle provides CommonDecoratedWindowStyle(isDarkTheme),
        LocalTitleBarStyle provides CommonTitleBarStyle(isDarkTheme)
    ) {
        DecoratedWindow(
            onCloseRequest = onCloseRequest,
            state = state,
            visible = visible,
            title = title,
            icon = icon,
            resizable = resizable,
            enabled = enabled,
            focusable = focusable,
            alwaysOnTop = alwaysOnTop,
            onPreviewKeyEvent = onPreviewKeyEvent,
            onKeyEvent = onKeyEvent,
            style = LocalDecoratedWindowStyle.current,
        ) {
            Column {
                TitleBarView(style = LocalTitleBarStyle.current, content = titleBarContent)
                content()
            }
        }
    }
}


@Composable
fun CommonDecoratedWindowStyle(isDark: Boolean): DecoratedWindowStyle {
    if (isDark) {
        return DecoratedWindowStyle.dark()
    } else {
        return DecoratedWindowStyle.light()
    }
}

@Composable
fun CommonTitleBarStyle(isDark: Boolean): TitleBarStyle {
    return if (isDark) {
        TitleBarStyle.dark()
    } else {
        TitleBarStyle.light()
    }
}