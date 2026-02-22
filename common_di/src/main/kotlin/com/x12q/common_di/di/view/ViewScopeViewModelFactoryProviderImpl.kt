package com.x12q.common_di.di.view

import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryProvider
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@Inject
@SingleIn(ViewComponent.Scope::class)
@ContributesBinding(ViewComponent.Scope::class)
class ViewScopeViewModelFactoryProviderImpl(
    @FromViewComponent
    override val provider: ViewModelFactoryProvider
) : ViewScopeViewModelFactoryProvider