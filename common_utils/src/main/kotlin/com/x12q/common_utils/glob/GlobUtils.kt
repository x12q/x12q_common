package com.x12q.common_utils.glob

/**
 * Glob pattern is a kind of simplified pattern matching.
 * This files contains support functions to work with glob pattern
 */
object GlobUtils {
    fun createRegexPatternFromGlob(glob: String): String {
        val rt = StringBuilder("^")
        for(char in glob){
            val newChar = when (char) {
                '*' -> ".*"
                '?' -> '.'
                '.' -> "\\."
                '\\' -> "\\\\"
                else -> char
            }
            rt.append(newChar)
        }
        rt.append('$')
        return rt.toString()
    }

    fun createRegexFromGlob(glob: String): Regex{
        return Regex("^${createRegexPatternFromGlob(glob)}$")
    }

}