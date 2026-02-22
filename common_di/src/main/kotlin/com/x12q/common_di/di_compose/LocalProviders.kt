package com.x12q.common_di.di_compose

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import com.x12q.common_di.di.global.GlobalComponent
import com.x12q.common_di.di.screen.ScreenComponent
import com.x12q.common_di.di.view.ViewComponent
import com.x12q.common_di.di.window.WindowComponent

val LocalGlobalComponentProvider: ProvidableCompositionLocal<GlobalComponent?> = compositionLocalOf { null }
val LocalWindowComponentProvider:ProvidableCompositionLocal<WindowComponent?> = compositionLocalOf { null }
val LocalScreenComponentProvider: ProvidableCompositionLocal<ScreenComponent?> = compositionLocalOf { null }
val LocalViewComponentProvider: ProvidableCompositionLocal<ViewComponent?> = compositionLocalOf { null }
