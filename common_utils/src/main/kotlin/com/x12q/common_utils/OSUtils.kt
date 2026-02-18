package com.x12q.common_utils

import org.apache.commons.lang3.SystemUtils
import oshi.PlatformEnum
import oshi.SystemInfo

object OSUtils {

    private val systemInfo: SystemInfo by lazy { SystemInfo() }
    private val osFamily by lazy { systemInfo.operatingSystem.family }

    val MAC: PlatformEnum = PlatformEnum.MACOS
    val WINDOW = PlatformEnum.WINDOWS
    val LINUX = PlatformEnum.LINUX

    fun <T> whenOs(
        onDebianOrUbuntu: () -> T = {
            throw OSNotSupported(currentOs())
        },
        onMac: () -> T = {
            throw OSNotSupported(currentOs())
        },
        onWindow: () -> T ={
            throw OSNotSupported(currentOs())
        },
    ): T {
        if (isDebianOrUbuntu()) {
            return onDebianOrUbuntu()
        }
        if (isMac()) {
            return onMac()
        }
        if (isWindow()) {
            return onWindow()
        }
        throw OSNotSupported(currentOs())
    }

    fun isDebianOrUbuntu(): Boolean {
        if (SystemUtils.IS_OS_LINUX) {
            when (osFamily.lowercase()) {
                "ubuntu", "debian" -> {
                    return true
                }
            }
        }
        return false
    }

    fun isMac(): Boolean {
        return SystemUtils.IS_OS_MAC
    }

    fun isWindow(): Boolean {
        return SystemUtils.IS_OS_WINDOWS
    }

    fun currentOs(): String {
        return systemInfo.operatingSystem.toString()
    }
}

/**
 * Problem: must prevent loading of mac dylib on linux. Otherwise, app will crash.
 * - Must detect OS at wire-up time. -> easy
 *      - in case wrong OS?
 *          -> crash the app?
 *          -> return null?
 *          ->
 * - The problem of non-crashing wiring:
 *      - wiring function that does not return null must either return a valid object or crash.
 *      - This force all implementation to conform to a single interface, so that it does not crash the app.
 */
