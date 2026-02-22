package com.x12q.common_di.di.view

import com.x12q.common_di.di.screen.ScreenComponent
import com.x12q.common_di.di.screen.ScreenScopeViewModelFactoryProvider
import com.x12q.common_di.di.viewmodel_di.AssistedInjectViewModelFactory
import com.x12q.common_di.di.viewmodel_di.ViewModelFactory
import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryContainer
import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryProvider
import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.ContributesSubcomponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@ContributesSubcomponent(ViewComponent.Scope::class)
@SingleIn(ViewComponent.Scope::class)
interface ViewComponent {
    object Scope

    @ContributesSubcomponent.Factory(ScreenComponent.Scope::class)
    interface Factory {
        fun createViewComponent(): ViewComponent
    }

    fun getViewModelFactoryProvider(): ViewScopeViewModelFactoryProvider

    @Provides
    @SingleIn(ViewComponent.Scope::class)
    fun provideViewModelFactoryProvider(
        factorySet: Set<ViewModelFactory> = emptySet(),
        assistedInjectFactories: Set<AssistedInjectViewModelFactory> = emptySet(),
    ): @FromViewComponent ViewModelFactoryProvider {
        return ViewModelFactoryProvider.from(
            name = "ViewComponent.ViewModelFactoryProvider",
            containers = listOf(
                ViewModelFactoryContainer(
                    factories = factorySet,
                    assistedInjectFactories = assistedInjectFactories,
                )
            )
        )
    }
}