package com.x12q.common_utils

/**
 * Developer bugs are bugs caused by developers misuse classes, function, etc.
 * These errors must not happen on users' space
 */
fun developerErrorMsg(msg:String):String{
    return "Developer bug: $msg"
}

/**
 * Impossible errors are errors that are impossible to happen.
 * Similar to developer error, this is often caused by misusing classes, functions, etc.
 * These errors must not happen on users' space.
 * But this function can also be used to crash the app on purpose and for documentation purposes.
 */
fun impossibleErr(msg:String):String{
    return "Impossible: $msg"
}

