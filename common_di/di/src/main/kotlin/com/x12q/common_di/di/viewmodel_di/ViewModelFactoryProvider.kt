package com.x12q.common_di.di.viewmodel_di

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass


class ViewModelFactoryProvider(
    val containers: List<ViewModelFactoryContainer>,
    /**
     * A name for debugging purposes
     */
    val name: String? = null,
) {
    inline fun <reified F> getAssistedFactory(): F? {
        for (vmFactoryContainer in containers) {
            val factory = vmFactoryContainer.getAssistedFactory<F>()
            if (factory != null) {
                return factory
            }
        }
        return null
    }

    fun <T : ViewModel> getFactoryByViewModelClass(vmClass: KClass<T>): ViewModelFactory? {
        for (mem in containers) {
            val factory = mem.getFactoryByViewModelClass(vmClass)
            if (factory != null) {
                return factory
            }
        }
        return null
    }

    /**
     * Create a new [ViewModelFactoryProvider] that contains all current members + [newMember].
     */
    fun withContainer(newMember: ViewModelFactoryContainer, newName: String? = null): ViewModelFactoryProvider {
        return ViewModelFactoryProvider(
            containers = containers + newMember,
            name = newName ?: name,
        )
    }

    companion object {
        fun from(name: String?, containers: List<ViewModelFactoryContainer>): ViewModelFactoryProvider {
            return ViewModelFactoryProvider(containers, name)
        }
    }
}
