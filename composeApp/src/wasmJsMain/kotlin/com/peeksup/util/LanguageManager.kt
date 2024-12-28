package com.peeksup.util

import kotlinx.browser.window

object LanguageManager {
    private var currentLang = Language.KOREAN  // 기본값

    private fun setLanguage(lang: String) {
        currentLang = when (lang.substringBefore("-")) {
            "ko" -> Language.KOREAN
            "en" -> Language.ENGLISH
            "zh" -> Language.CHINESE
            "ja" -> Language.JAPANESE
            "tr" -> Language.TURKISH
            "id" -> Language.INDONESIAN
            else -> Language.ENGLISH  // 지원하지 않는 언어는 영어로
        }
    }

    fun getString(key: StringKey): String {
        return Strings.getString(currentLang, key)
    }

    fun getResponseString(key: ResponseKey): String {
        return Strings.getResponseString(currentLang, key)
    }

    // 현재 언어 가져오기
    fun getCurrentLanguage(): Language = currentLang

    // 브라우저 언어로 초기화
    init {
        setLanguage(window.navigator.language)
    }
}