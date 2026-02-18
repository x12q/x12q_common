package com.x12q.common_utils


/**
 * A bi-directional map that allow two-way lookup using both key and value
 */
data class BiMap<K, V>(
    val map: Map<K, V> = emptyMap(),
    val reversedMap: Map<V, K> = emptyMap(),
) {

    val keys get() = map.keys
    val values get() = map.values

    fun filter(filter: (K, V) -> Boolean): BiMap<K, V> {
        return BiMap(
            map = map.filter { (k, v) -> filter(k, v) },
            reversedMap = reversedMap.filter { (v, k) -> filter(k, v) }
        )
    }

    fun getByKey(key: K): V? {
        return map[key]
    }

    fun getByValue(value: V): K? {
        return reversedMap[value]
    }

    fun add(key: K, value: V): BiMap<K, V> {
        return BiMap(
            map = map + (key to value),
            reversedMap = reversedMap + (value to key)
        )
    }

    fun add(pairs: List<Pair<K, V>>): BiMap<K, V> {
        return BiMap(
            map = map + pairs,
            reversedMap = reversedMap + pairs.map { Pair(it.second, it.first) }
        )
    }

    fun removeByKey(keys: Collection<K>): BiMap<K, V> {
        val toBeRemovedValues: List<V> = keys.mapNotNull {
            map[it]
        }
        if (toBeRemovedValues.isNotEmpty()) {
            return BiMap(
                map = map - keys.toSet(),
                reversedMap = reversedMap - toBeRemovedValues.toSet()
            )
        } else {
            return this
        }
    }

    fun removeByKey(vararg keys: K): BiMap<K, V> {
        return removeByKey(keys.toList())
    }

    fun removeByValue(values: Collection<V>): BiMap<K, V> {
        val keysToBeRemoved: List<K> = values.mapNotNull {
            reversedMap[it]
        }
        if (keysToBeRemoved.isNotEmpty()) {
            return BiMap(
                map = map - keysToBeRemoved.toSet(),
                reversedMap = reversedMap - values.toSet()
            )
        } else {
            return this
        }
    }

    fun removeByValue(vararg values: V): BiMap<K, V> {
        return removeByValue(values.toList())
    }

    fun containsKey(key:K):Boolean{
        return map.containsKey(key) && reversedMap.containsValue(key)
    }

    fun containsValue(value:V):Boolean{
        return reversedMap.containsKey(value) && map.containsValue(value)
    }
}
