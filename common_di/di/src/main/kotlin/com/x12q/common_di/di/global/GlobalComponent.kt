package com.x12q.common_di.di.global

import com.x12q.common_di.di.window.WindowComponent
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn


@MergeComponent(GlobalComponent.Scope::class)
@SingleIn(GlobalComponent.Scope::class)
interface GlobalComponent{

    fun windowComponentFactory(): WindowComponent.Factory

    object Scope
}


