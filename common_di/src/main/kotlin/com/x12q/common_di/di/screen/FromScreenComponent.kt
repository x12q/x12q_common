package com.x12q.common_di.di.screen

import me.tatarka.inject.annotations.Qualifier

/**
 * Screen component may have bindings of the same type as those from Global or Window component.
 * This marker qualifier is to differentiate what from Screen component from that.
 */
@Qualifier
@Target(
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE
)
annotation class FromScreenComponent