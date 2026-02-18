package com.x12q.common_utils

import java.nio.file.Path

sealed class FileUtilError{
    data class CannotCreateFile(val e: Exception):FileUtilError()
    data class CannotWriteToFile(val file: Path, val content:String):FileUtilError()
    data class CannotReadFile(val file: Path, val e: Exception):FileUtilError()
    data class CannotWriteLinesToFile(val file: Path, val lines:List<String>):FileUtilError()
    data class CannotDeleteFile(val file: Path):FileUtilError()
}