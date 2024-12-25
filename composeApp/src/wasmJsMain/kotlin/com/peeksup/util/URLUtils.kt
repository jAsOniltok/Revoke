package com.peeksup.util

import com.peeksup.food.foodList
import kotlinx.browser.window
import org.w3c.dom.url.URLSearchParams

@JsName("encodeURIComponent")
external fun encodeURIComponent(str: String): String

@JsName("decodeURIComponent")
external fun decodeURIComponent(str: String): String

object URLUtils {
    fun encodeResponsesToURL(responses: Map<String, String>): String {
        // 음식 이름을 StringKey로 변환하고 URL 생성
        val baseUrl = window.location.origin + window.location.pathname
        val params = responses.entries.joinToString("&") { (foodName, response) ->
            // 음식 이름을 StringKey로 변환
            val foodKey = foodList.find {
                LanguageManager.getString(it.stringKey) == foodName
            }?.stringKey?.name

            // 응답을 ResponseKey로 변환
            val responseKey = ResponseKey.entries.find {
                LanguageManager.getResponseString(it) == response
            }?.name

            "${encodeURIComponent(foodKey ?: "")}=${encodeURIComponent(responseKey ?: "")}"
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
                    val (foodKey, responseKey) = param.split("=", limit = 2)
                    val decodedFoodKey = decodeURIComponent(foodKey)
                    val decodedResponseKey = decodeURIComponent(responseKey)

                    // StringKey -> 현재 언어의 음식 이름
                    val foodName = LanguageManager.getString(StringKey.valueOf(decodedFoodKey))
                    // ResponseKey -> 현재 언어의 응답
                    val response = LanguageManager.getResponseString(ResponseKey.valueOf(decodedResponseKey))

                    foodName to response
                }
        } catch (e: Exception) {
            null
        }
    }
}