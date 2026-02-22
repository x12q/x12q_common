package com.x12q.common_di.di.screen

import com.x12q.common_di.di.viewmodel_di.AssistedInjectViewModelFactory
import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryContainer
import com.x12q.common_di.di.viewmodel_di.ViewModelFactoryProvider
import com.x12q.common_di.di.viewmodel_di.ViewModelFactory
import com.x12q.common_di.di.window.WindowComponent
import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.ContributesSubcomponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

/**
 * A subcomponent of [WindowComponent].
 * This component hold dependencies that should be only accessible to "screen".
 * Specific screen (such as MainScreen) can depend on this component to get common dependencies.
 */
@ContributesSubcomponent(ScreenComponent.Scope::class)
@SingleIn(ScreenComponent.Scope::class)
interface ScreenComponent {
    object Scope

    @ContributesSubcomponent.Factory(WindowComponent.Scope::class)
    interface Factory {
        fun createScreenComponent(): ScreenComponent
    }

    fun getViewModelFactoryProvider(): ScreenScopeViewModelFactoryProvider

    @Provides
    @SingleIn(Scope::class)
    fun provideViewModelFactoryProvider(
        factorySet: Set<ViewModelFactory> = emptySet(),
        assistedInjectFactories: Set<AssistedInjectViewModelFactory> = emptySet(),
    ): @FromScreenComponent ViewModelFactoryProvider {
        return ViewModelFactoryProvider.from(
            name = "ScreenComponent.ViewModelFactoryProvider",
            containers = listOf(
                ViewModelFactoryContainer(
                    factories = factorySet,
                    assistedInjectFactories = assistedInjectFactories,
                )
            )
        )
    }
}