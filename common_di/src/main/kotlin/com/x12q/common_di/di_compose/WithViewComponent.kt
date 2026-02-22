package com.x12q.common_di.di_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.x12q.common_di.di.view.ViewComponent
import com.x12q.common_di.di.viewmodel_di.LocalViewModeFactoryProvider

@Composable
fun ScreenScope.WithViewComponent(
    content: @Composable ViewScope.() -> Unit,
) {
    val viewComponent = remember {
        screenComponent.getViewComponentFactory().createViewComponent()
    }

    val viewScope = remember {
        object : ViewScope {
            override val viewComponent: ViewComponent = viewComponent
        }
    }

    CompositionLocalProvider(
        LocalViewComponentProvider provides viewComponent,
        LocalViewModeFactoryProvider provides viewComponent.getViewModelFactoryProvider().provider
    ) {
        viewScope.content()
    }
}