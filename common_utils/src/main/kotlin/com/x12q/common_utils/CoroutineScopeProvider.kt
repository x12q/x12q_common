package com.x12q.common_utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.reflect.KProperty

/**
 * A common interface to allow calling [getValue] function using "by" keyword on any children implementation of this interface.
 */
fun interface CoroutineScopeProvider {
    fun coroutineScope(): CoroutineScope
}

/**
 * Enable using "by" keyword to get the coroutine scope object in a [CoroutineScopeProvider]
 */
@Suppress("NOTHING_TO_INLINE")
inline operator fun CoroutineScopeProvider.getValue(thisObj: Any?, property: KProperty<*>): CoroutineScope {
    return this.coroutineScope()
}


class BaseCoroutineScopeProvider(): CoroutineScopeProvider {
    private val cr: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    override fun coroutineScope(): CoroutineScope {
        return cr
    }
}



