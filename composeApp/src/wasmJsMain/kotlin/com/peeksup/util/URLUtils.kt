package com.peeksup.util

import kotlinx.browser.window
import org.w3c.dom.url.URLSearchParams

@JsName("encodeURIComponent")
external fun encodeURIComponent(str: String): String

@JsName("decodeURIComponent")
external fun decodeURIComponent(str: String): String

object URLUtils {
    fun encodeResponsesToURL(responses: Map<String, String>): String {
        val baseUrl = window.location.origin + window.location.pathname
        val params = responses.entries.joinToString("&") { (food, response) ->
            "${encodeURIComponent(food)}=${encodeURIComponent(response)}"
        }
        return "$baseUrl?$params"
    }

    fun decodeURLToResponses(url: String): Map<String, String>? {
        return try {
            val searchStr = window.location.search
            if (searchStr.isEmpty() || searchStr == "?") return null

            searchStr.substring(1)
                .split("&")
                .associate { param ->
                    val (key, value) = param.split("=", limit = 2)
                    decodeURIComponent(key) to decodeURIComponent(value)
                }
        } catch (e: Exception) {
            null
        }
    }
}