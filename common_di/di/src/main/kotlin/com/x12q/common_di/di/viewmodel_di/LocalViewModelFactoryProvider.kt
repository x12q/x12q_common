package com.x12q.common_di.di.viewmodel_di

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

val LocalViewModeFactoryProvider: ProvidableCompositionLocal<ViewModelFactoryProvider?> = compositionLocalOf { null }