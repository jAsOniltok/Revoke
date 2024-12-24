package com.peeksup.util

@JsName("umami")
external object umami {
    fun track(event_name: String)  // 데이터 없이 이벤트만 트래킹
    fun track(event_name: String, event_data: String)  // 데이터와 함께 트래킹
}

