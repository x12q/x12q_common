package com.x12q.common_di.di.viewmodel_di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Get a view model [V] that has a fully injectable constructor.
 */
@Composable
inline fun <reified V : ViewModel> getVM(): V {
    val factoryProvider: ViewModelFactoryProvider = checkNotNull(LocalViewModeFactoryProvider.current) {
        "${ViewModelFactoryProvider::class.simpleName} is not available"
    }
    val factory = checkNotNull(factoryProvider.getFactoryByViewModelClass(V::class)) {
        "${factoryProvider.name} cannot provide view mode of type ${V::class}"
    }
    return viewModel { factory.createVM() as V}
}

/**
 * Get a view model [V] that can be created by an assisted factory [F].
 */
@Composable
inline fun <reified V : ViewModel, reified F> getVM(
    crossinline create: (F) -> V
): V {
    val factoryProvider: ViewModelFactoryProvider = checkNotNull(LocalViewModeFactoryProvider.current) {
        "${ViewModelFactoryProvider::class.simpleName} is not available"
    }
    val factory = checkNotNull(factoryProvider.getAssistedFactory<F>()){
        "Assisted factory for ${F::class} not found in the local ViewModelFactoryProvider"
    }

    return viewModel { create(factory) }
}
