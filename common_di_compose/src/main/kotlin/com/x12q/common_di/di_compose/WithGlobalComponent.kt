package com.x12q.common_di.di_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ApplicationScope
import com.x12q.common_di.di.global.GlobalComponent


@Composable
fun ApplicationScope.WithGlobalComponent(
    globalComponentFactory: () -> GlobalComponent,
    content: @Composable GlobalScope.() -> Unit,
) {
    val globalComponent = remember {
        globalComponentFactory()
    }

    val globalComponentAccessorScope = remember {
        object : GlobalScope {
            override val globalComponent: GlobalComponent = globalComponent
        }
    }

    CompositionLocalProvider(
        LocalGlobalComponentProvider provides globalComponent,
        content = {
            globalComponentAccessorScope.content()
        },
    )
}