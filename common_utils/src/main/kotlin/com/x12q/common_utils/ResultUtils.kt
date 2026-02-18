package com.x12q.common_utils

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.get

fun <V, E: Throwable> Result<V, E>.getOrThrow():V{
    when(this){
        is Err -> throw error
        is Ok -> return value
    }
}