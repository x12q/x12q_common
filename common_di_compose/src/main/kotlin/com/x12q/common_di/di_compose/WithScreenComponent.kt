package com.x12q.common_di.di_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.x12q.common_di.di.screen.ScreenComponent
import com.x12q.common_di.di.viewmodel_di.LocalViewModeFactoryProvider


@Composable
fun WindowScope.WithScreenComponent(
    content: @Composable ScreenScope.() -> Unit,
){
    val screenComponent = remember {
        windowComponent.screenComponentFactory().createScreenComponent()
    }

    val screenScope = remember {
        object: ScreenScope {
            override val screenComponent: ScreenComponent = screenComponent
        }
    }

    CompositionLocalProvider(
        LocalScreenComponentProvider provides screenComponent,
        LocalViewModeFactoryProvider provides screenComponent.getViewModelFactoryProvider().provider,
        content = {
            screenScope.content()
        }
    )
}
