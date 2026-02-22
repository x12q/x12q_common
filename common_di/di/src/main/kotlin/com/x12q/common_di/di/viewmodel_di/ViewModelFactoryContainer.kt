package com.x12q.common_di.di.viewmodel_di

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass


/**
 * This contains view-model-factories and allows looking up such factories using the class of the view model.
 */
class ViewModelFactoryContainer(
    factories: Set<ViewModelFactory>,
    assistedInjectFactories: Set<AssistedInjectViewModelFactory>
) {

    val vmFactoryMap: Map<KClass<*>, ViewModelFactory> = factories.associateBy { it.classKey }

    /**
     * Assisted factories are mapped to their own classes.
     */
    val assistedInjectFactoryMap: Map<KClass<*>, AssistedInjectViewModelFactory> = assistedInjectFactories.associateBy { it::class }

    inline fun <reified F> getAssistedFactory(): F? {
        return assistedInjectFactoryMap[F::class] as F?
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : ViewModel> getFactoryByViewModelClass(vmClass: KClass<T>): ViewModelFactory? {
        return vmFactoryMap[vmClass]
    }
}

