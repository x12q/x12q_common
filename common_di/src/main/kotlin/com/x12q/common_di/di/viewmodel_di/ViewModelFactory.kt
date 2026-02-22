package com.x12q.common_di.di.viewmodel_di

import kotlin.reflect.KClass

/**
 * This one is for view model that have its parameters fully injected by the DI graph
 */
interface ViewModelFactory<T:Any>  {
    val classKey: KClass<T>
    fun createVM(): T

    companion object Companion {
        /**
         * A short-cut function to create a view model factory object from a factory function
         */
        inline fun <reified T:Any> of(noinline createVM: () -> T): ViewModelFactory<T> {
            return object : ViewModelFactory<T> {
                override val classKey: KClass<T> = T::class

                override fun createVM(): T {
                    return createVM()
                }
            }
        }
    }
}
