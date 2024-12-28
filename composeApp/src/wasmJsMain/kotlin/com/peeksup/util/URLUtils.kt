package com.peeksup.util

import kotlinx.browser.window

@JsName("encodeURIComponent")
external fun encodeURIComponent(str: String): String

@JsName("decodeURIComponent")
external fun decodeURIComponent(str: String): String

object URLUtils {
    fun encodeResponsesToURL(surveyType: SurveyType, responses: Map<String, String>): String {
        val baseUrl = window.location.origin + window.location.pathname
        val items = SurveyItems.getItemsByType(surveyType)

        val compressed = buildString {
            append(SurveyType.entries.indexOf(surveyType).toString(16))

            responses.forEach { (itemName, response) ->
                val itemIndex = items.indexOfFirst {
                    LanguageManager.getString(it.stringKey) == itemName
                }.toString(16).padStart(2, '0')

                // ResponseKey.getByType 사용
                val responseKeys = ResponseKey.getByType(surveyType)
                val responseIndex = responseKeys.indexOfFirst {
                    LanguageManager.getResponseString(it) == response
                }.toString(16).padStart(2, '0')

                append(itemIndex)
                append(responseIndex)
            }
        }

        return "$baseUrl?d=$compressed"
    }

    fun decodeURLToResponses(url: String): Pair<SurveyType, Map<String, String>>? {
        return try {
            val searchStr = window.location.search
            if (searchStr.isEmpty() || searchStr == "?") return null

            val compressed = searchStr.substringAfter("d=")
            val surveyType = SurveyType.entries[compressed.substring(0, 1).toInt(16)]
            val items = SurveyItems.getItemsByType(surveyType)

            val responses = compressed.substring(1).chunked(4).associate { chunk ->
                val itemIndex = chunk.substring(0, 2).toInt(16)
                val responseIndex = chunk.substring(2, 4).toInt(16)

                val itemKey = items[itemIndex].stringKey
                val itemName = LanguageManager.getString(itemKey)

                // ResponseKey.getByType 사용
                val responseKeys = ResponseKey.getByType(surveyType)
                val responseKey = responseKeys[responseIndex]
                val response = LanguageManager.getResponseString(responseKey)

                itemName to response
            }

            surveyType to responses

        } catch (e: Exception) {
            null
        }
    }
}