package com.x12q.common_di.di_compose

import com.x12q.common_di.di.global.GlobalComponent


/**
 * Provide access to a [GlobalComponent], this is used as the medium between provider and accessor of [GlobalComponent].
 * See [WithGlobalComponent].
 */
interface GlobalScope {
    val globalComponent: GlobalComponent
}