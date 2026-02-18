package com.x12q.common_utils

import java.util.AbstractMap

fun <K, V> Pair<K, V>.toMapEntry(): Map.Entry<K, V> {
    return AbstractMap.SimpleEntry(first,second)
}
