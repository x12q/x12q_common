package com.x12q.common_utils

@RequiresOptIn("This is only for testing and prototyping, don't use in production code")
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class ForTestOnly
