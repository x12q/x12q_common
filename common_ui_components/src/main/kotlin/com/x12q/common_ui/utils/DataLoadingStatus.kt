package com.x12q.common_ui.utils

sealed class DataLoadingStatus<out T, out E> {
    fun getDataOrNull(): T? {
        return (this as? LoadedData)?.data
    }
}

data class LoadedData<out T>(val data: T) : DataLoadingStatus<T, Nothing>()
data class LoadError<out E>(val error: E) : DataLoadingStatus<Nothing, E>()
data object Loading : DataLoadingStatus<Nothing, Nothing>()


fun <T1, T2, E> DataLoadingStatus<T1, E>.map(
    transform: (T1) -> T2
): DataLoadingStatus<T2, E> {
    return this.transform(
        transformData = transform, transformErr = {it}
    )
}

fun <T1, T2, E1, E2> DataLoadingStatus<T1, E1>.transform(
    transformData: (T1) -> T2,
    transformErr: (E1) -> E2,
): DataLoadingStatus<T2, E2> {
    val rt = when (this) {
        is LoadError -> LoadError(transformErr(this.error))
        is LoadedData -> LoadedData(transformData(this.data))
        Loading -> Loading
        // NotStartedYet -> NotStartedYet
    }
    return rt
}
