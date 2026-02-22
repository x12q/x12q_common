package com.x12q.common_di.di.window

import me.tatarka.inject.annotations.Qualifier

/**
 * Window component may have bindings of the same type as those from Global or Screen component.
 * This marker qualifier is to differentiate what from Window component from that.
 */
@Qualifier
@Target(
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE
)
annotation class FromWindowComponent