package com.x12q.common_ui.window

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.intui.window.styling.dark
import org.jetbrains.jewel.intui.window.styling.light
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.DecoratedWindowScope
import org.jetbrains.jewel.window.TitleBar
import org.jetbrains.jewel.window.TitleBarScope
import org.jetbrains.jewel.window.defaultDecoratedWindowStyle
import org.jetbrains.jewel.window.newFullscreenControls
import org.jetbrains.jewel.window.styling.DecoratedWindowStyle
import org.jetbrains.jewel.window.styling.LocalDecoratedWindowStyle
import org.jetbrains.jewel.window.styling.LocalTitleBarStyle
import org.jetbrains.jewel.window.styling.TitleBarStyle

/**
 * a preconfig wrapper for [TitleBar]
 */
@Composable
fun DecoratedWindowScope.TitleBarView(
    modifier: Modifier = Modifier,
    content: @Composable TitleBarScope.()->Unit,
) {
    TitleBar(
        /**
         * This allows the controller buttons to show up as part of the screen
         * when the app goes into full-screen mode.
         */
        modifier.newFullscreenControls()
    ){
        content()
    }
}

/**
 * A convenient wrapper of jewel title bar and decorated window.
 */
@Composable
fun CommonWindow(
    onCloseRequest: () -> Unit,
    state: WindowState = rememberWindowState(),
    visible: Boolean = true,
    title: String = "",
    icon: Painter? = null,
    resizable: Boolean = true,
    enabled: Boolean = true,
    focusable: Boolean = true,
    alwaysOnTop: Boolean = false,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    style: DecoratedWindowStyle = JewelTheme.defaultDecoratedWindowStyle,
    isDarkTheme: Boolean = true,
    titleBarContent: @Composable TitleBarScope.()->Unit,
    content: @Composable DecoratedWindowScope.() -> Unit,
){
    CompositionLocalProvider(
        LocalDecoratedWindowStyle provides CommonDecoratedWindowStyle(isDarkTheme),
        LocalTitleBarStyle provides CommonTitleBarStyle(isDarkTheme)
    ){
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
            style = style,
        ){
            Column {
                TitleBarView(content = titleBarContent)
                content()
            }
        }
    }
}


@Composable
fun CommonDecoratedWindowStyle(isDark: Boolean):DecoratedWindowStyle {
    if(isDark){
        return DecoratedWindowStyle.dark()
    }else{
        return DecoratedWindowStyle.light()
    }
}

@Composable
fun CommonTitleBarStyle(isDark: Boolean):TitleBarStyle{
    return if(isDark){
        TitleBarStyle.dark()
    }else{
        TitleBarStyle.light()
    }
}