package com.peeksup.util

import com.peeksup.food.foodList
import kotlinx.browser.window
import org.w3c.dom.url.URLSearchParams
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@JsName("encodeURIComponent")
external fun encodeURIComponent(str: String): String

@JsName("decodeURIComponent")
external fun decodeURIComponent(str: String): String

object URLUtils {
    fun encodeResponsesToURL(responses: Map<String, String>): String {
        val baseUrl = window.location.origin + window.location.pathname

        // responses를 압축된 문자열로 변환
        val compressed = buildString {
            responses.forEach { (foodName, response) ->
                // 음식 이름을 인덱스로 변환 (2자리 hex)
                val foodIndex = foodList.indexOfFirst {
                    LanguageManager.getString(it.stringKey) == foodName
                }.toString(16).padStart(2, '0')

                // 응답을 인덱스로 변환 (2자리 hex)
                val responseIndex = ResponseKey.entries.indexOfFirst {
                    LanguageManager.getResponseString(it) == response
                }.toString(16).padStart(2, '0')

                append(foodIndex)
                append(responseIndex)
            }
        }

        return "$baseUrl?d=$compressed"
    }

    fun decodeURLToResponses(url: String): Map<String, String>? {
        return try {
            val searchStr = window.location.search
            if (searchStr.isEmpty() || searchStr == "?") return null

            // URL 파라미터에서 압축된 문자열 추출
            val compressed = searchStr.substringAfter("d=")

            // 4자리씩 끊어서 Map으로 변환 (음식 2자리 + 응답 2자리)
            compressed.chunked(4).associate { chunk ->
                val foodIndex = chunk.substring(0, 2).toInt(16)
                val responseIndex = chunk.substring(2, 4).toInt(16)

                // 인덱스로 음식 이름 찾기
                val foodKey = foodList[foodIndex].stringKey
                val foodName = LanguageManager.getString(foodKey)

                // 인덱스로 응답 찾기
                val responseKey = ResponseKey.entries[responseIndex]
                val response = LanguageManager.getResponseString(responseKey)

                foodName to response
            }
        } catch (e: Exception) {
            null
        }
    }
}