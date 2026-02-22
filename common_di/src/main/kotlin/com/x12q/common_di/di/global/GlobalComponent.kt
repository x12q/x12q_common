package com.x12q.common_di.di.global

import com.x12q.common_di.di.window.WindowComponent


interface GlobalComponent{

    fun windowComponentFactory(): WindowComponent.Factory

    object Scope
}


