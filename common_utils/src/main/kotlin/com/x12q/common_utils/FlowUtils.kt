package com.x12q.common_utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

fun <T> Flow<T>.toStateFlow(
    coroutineScope: CoroutineScope,
    initValue:T,
    sharingStarted: SharingStarted = SharingStarted.WhileSubscribed(5000),
): StateFlow<T>{
    return this.stateIn(coroutineScope, sharingStarted,initValue)
}

