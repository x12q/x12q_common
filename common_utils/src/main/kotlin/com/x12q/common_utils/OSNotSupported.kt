package com.x12q.common_utils

class OSNotSupported(val os:String): Exception("$os is not supported, the app will now close.")