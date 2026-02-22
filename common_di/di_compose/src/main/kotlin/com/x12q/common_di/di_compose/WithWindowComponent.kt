package com.x12q.common_di.di_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.x12q.common_di.di.window.WindowComponent

@Composable
fun GlobalScope.WithWindowComponent(
    content: @Composable WindowScope.() -> Unit,
) {
    val windowComponent = remember {
        globalComponent.windowComponentFactory().createWindowComponent()
    }
    val screenComponentAccessingScope = remember {
        object : WindowScope {
            override val windowComponent: WindowComponent = windowComponent
        }
    }

    CompositionLocalProvider(
        LocalWindowComponentProvider provides windowComponent
    ) {
        screenComponentAccessingScope.content()
    }
}
