package com.x12q.common_utils

import java.util.Random
import java.util.UUID

object RandomUtils {
    val rand:Random = Random()

    fun randomStr(prefix:String?=null,separator:String="-"):String{
        if(prefix!=null){
            return "$prefix$separator${UUID.randomUUID()}"
        }else{
            return UUID.randomUUID().toString()
        }
    }

    fun randomByteArray(prefix:String?=null,separator:String="-"): ByteArray{
        return randomStr(prefix,separator).toByteArray()
    }

    fun randomHost(): String {
        val hosts = listOf(
            "localhost",
            "example.com",
            "example.org",
            "example.net",
            "test.com",
            "demo.com"
        )
        return hosts.random()
    }

    fun randomPort(): Int {
        return (1024..65535).random()
    }


}
