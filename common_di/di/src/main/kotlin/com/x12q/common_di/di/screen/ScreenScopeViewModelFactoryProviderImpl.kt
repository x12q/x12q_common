package com.x12q.common_di.di.screen

import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryProvider
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

/**
 * Wrapper that marks a [ViewModelFactoryProvider] as belonging to a window scope.
 * ViewModels resolved through this provider are tied to the lifetime of a single window.
 */
@Inject
@SingleIn(ScreenComponent.Scope::class)
@ContributesBinding(ScreenComponent.Scope::class)
class ScreenScopeViewModelFactoryProviderImpl(
    @FromScreenComponent
    override val provider: ViewModelFactoryProvider
) : ScreenScopeViewModelFactoryProvider