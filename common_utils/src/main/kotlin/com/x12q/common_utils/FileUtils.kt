package com.x12q.common_utils

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import com.github.michaelbull.result.onFailure
import java.nio.file.Path
import kotlin.io.path.createFile
import kotlin.io.path.createTempFile
import kotlin.io.path.deleteIfExists
import kotlin.io.path.readLines
import kotlin.io.path.writeLines
import kotlin.io.path.writeText

/**
 * Create a temp file.
 */
fun createTempFileRs(
    prefix: String,
    suffix: String,
): Result<Path, FileUtilError.CannotCreateFile>{
    try{
        return Ok(createTempFile(prefix = prefix, suffix = suffix))
    }catch (e: Exception){
        return Err(FileUtilError.CannotCreateFile(e))
    }
}

/**
 * Create a temporary + executable file
 */
fun createTempExecutableFileRs(
    filePrefix: String,
    fileSuffix: String,
    fileContent: String
): Result<Path, FileUtilError> {

    val q = createTempFileRs(filePrefix, fileSuffix)
        .andThen { file->
            file.toFile().setExecutable(true, true)
            file.writeTextRs(fileContent)
                .onFailure {
                    file.deleteIfExistsRs()
                }
        }
    return q
}

/**
 * Read all lines
 */
fun Path.readLinesRs(): Result<List<String>, FileUtilError>{
    try{
        return Ok(readLines())
    }catch (e: Exception){
        return Err(FileUtilError.CannotReadFile(this, e))
    }
}

/**
 * Create a file at [this] path
 */
fun Path.createFileRs():Result<Path, FileUtilError>{
    try{
        return Ok(createFile())
    }catch (e: Exception){
        return Err(FileUtilError.CannotCreateFile(e))
    }
}

/**
 * write multiple lines
 */
fun Path.writeLinesRs(lines:List<String>): Result<Path, FileUtilError> {
    try{
        return Ok(writeLines(lines))
    }catch (e: Exception){
        return Err(FileUtilError.CannotWriteLinesToFile(this,lines))
    }
}

/**
 * Write a string
 */
fun Path.writeTextRs(text:String): Result<Path, FileUtilError> {
    try{
        writeText(text)
        return Ok(this)
    }catch (e: Exception){
        return Err(FileUtilError.CannotWriteToFile(this,text))
    }
}

/**
 * Delete a file
 */
fun Path.deleteIfExistsRs():Result<Unit, FileUtilError>{
    try{
        deleteIfExists()
        return Ok(Unit)
    }catch (e: Exception){
        return Err(FileUtilError.CannotDeleteFile(this))
    }
}



