package com.peeksup.util

import kotlinx.browser.window

fun isWasmGCSupported(): Boolean {
    return try {
        val testValue = window.navigator.userAgent
        true
    } catch (e: Exception) {
        false
    }
}