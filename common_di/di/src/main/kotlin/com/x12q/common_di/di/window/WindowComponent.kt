package com.x12q.common_di.di.window

import com.x12q.common_di.di.global.GlobalComponent
import com.x12q.common_di.di.screen.ScreenComponent
import com.x12q.common_di.di.viewmodel_di.AssistedInjectViewModelFactory
import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryContainer
import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryProvider
import com.x12q.common_di.di.viewmodel_di.ViewModelFactory
import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.ContributesSubcomponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

/**
 * A subcomponent of [GlobalComponent].
 * This hold dependency that should be accessible only to "window"
 */
@ContributesSubcomponent(WindowComponent.Scope::class)
@SingleIn(WindowComponent.Scope::class)

interface WindowComponent {

    object Scope

    @ContributesSubcomponent.Factory(GlobalComponent.Scope::class)
    interface Factory {
        fun createWindowComponent(): WindowComponent
    }

    fun screenComponentFactory(): ScreenComponent.Factory
    fun getViewModelFactoryProvider(): WindowScopeViewModelFactoryProvider

    @Provides
    @SingleIn(Scope::class)
    fun provideViewModelFactoryProvider(
        factorySet: Set<ViewModelFactory> = emptySet(),
        assistedInjectFactories: Set<AssistedInjectViewModelFactory> = emptySet(),
    ): @FromWindowComponent ViewModelFactoryProvider {
        return ViewModelFactoryProvider.from(
            name = "WindowComponent.ViewModelFactoryProvider",
            containers = listOf(
                ViewModelFactoryContainer(
                    factories = factorySet,
                    assistedInjectFactories = assistedInjectFactories,
                )
            )
        )
    }


}