package com.x12q.common_ui.preview_views

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.x12q.common_ui.theme.BaseTheme


fun previewApp(
    content: @Composable ()-> Unit,
){
    application {
        Window(onCloseRequest = {this.exitApplication()}){
            BaseTheme(isDarkTheme =  true){
                content()
            }
        }
    }
}

