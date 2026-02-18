package com.x12q.common_utils

fun <T> tryOr(doWork: () -> T, otherwise: () -> T): T {
    return try {
        doWork()
    } catch (_: Throwable) {
        otherwise()
    }
}

fun <T> tryOrNull(doWork: () -> T): T? {
    return try {
        doWork()
    } catch (_: Throwable) {
        return null
    }
}