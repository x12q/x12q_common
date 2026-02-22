package com.x12q.common_di.di.viewmodel_di

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass


/**
 * This contains view-model-factories and allows looking up such factories using the class of the view model.
 */
class ViewModelFactoryContainer(
    factories: Set<ViewModelFactory<*>>,
    assistedInjectFactories: Set<AssistedInjectViewModelFactory<*>>
) {

    val vmFactoryMap: Map<KClass<*>, ViewModelFactory<*>> = factories.associateBy { it.classKey }

    /**
     * Assisted factories are mapped to their own classes.
     * The reason is that the overload of `getVM` that require factory also provide the type of the factory. So there's no need to use the type of the VM for looking up.
     */
    val assistedInjectFactoryMap: Map<KClass<*>, AssistedInjectViewModelFactory<*>> = assistedInjectFactories.associateBy { it::class }

    inline fun <reified F> getAssistedFactory(): F? {
        return assistedInjectFactoryMap[F::class] as F?
    }

    @Suppress("UNCHECKED_CAST")
    fun getFactoryByViewModelClass(vmClass: KClass<*>): ViewModelFactory<*>? {
        return vmFactoryMap[vmClass]
    }
}

