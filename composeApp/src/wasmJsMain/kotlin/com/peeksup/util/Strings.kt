package com.peeksup.util

enum class Language(val code: String) {
    KOREAN("ko"),
    ENGLISH("en"),
    CHINESE("zh"),
    JAPANESE("ja"),
    TURKISH("tr"),
    INDONESIAN("id")
}

enum class StringKey {
    TITLE,
    RESULT,
    RESTART,
    COPY_LINK,
    COPIED,

    FOOD_KIMCHI_STEW,
    FOOD_BIBIMBAP,
    FOOD_BULGOGI,
    FOOD_PORK_BELLY,
    FOOD_SOYBEAN_STEW
}

enum class ResponseKey {
    HATE,
    DISLIKE,
    NEUTRAL,
    LIKE,
    LOVE
}

object Strings {
    private val translations = mapOf(
        Language.KOREAN.code to mapOf(
            StringKey.TITLE to "얼마나 좋아하세요?",
            StringKey.RESULT to "응답 결과",
            StringKey.RESTART to "다시 시작",
            StringKey.COPY_LINK to "결과 링크 복사하기",
            StringKey.COPIED to "링크가 복사되었습니다!",
            StringKey.FOOD_KIMCHI_STEW to "김치찌개",
            StringKey.FOOD_BIBIMBAP to "비빔밥",
            StringKey.FOOD_BULGOGI to "불고기",
            StringKey.FOOD_PORK_BELLY to "삼겹살",
            StringKey.FOOD_SOYBEAN_STEW to "된장찌개",
            "responses" to mapOf(
                ResponseKey.HATE to "절대 안(못)먹어",
                ResponseKey.DISLIKE to "별로 안좋아해",
                ResponseKey.NEUTRAL to "보통이야",
                ResponseKey.LIKE to "좋아해",
                ResponseKey.LOVE to "엄청 좋아해"
            )
        ),
        Language.ENGLISH.code to mapOf(
            StringKey.TITLE to "How much do you like it?",
            StringKey.RESULT to "Survey Results",
            StringKey.RESTART to "Start Over",
            StringKey.COPY_LINK to "Copy Result Link",
            StringKey.COPIED to "Link copied!",
            StringKey.FOOD_KIMCHI_STEW to "Kimchi Stew",
            StringKey.FOOD_BIBIMBAP to "Bibimbap",
            StringKey.FOOD_BULGOGI to "Bulgogi",
            StringKey.FOOD_PORK_BELLY to "Pork Belly",
            StringKey.FOOD_SOYBEAN_STEW to "Soybean Paste Stew",
            "responses" to mapOf(
                ResponseKey.HATE to "Hate it",
                ResponseKey.DISLIKE to "Don't like it",
                ResponseKey.NEUTRAL to "It's okay",
                ResponseKey.LIKE to "Like it",
                ResponseKey.LOVE to "Love it"
            )
        ),
        Language.CHINESE.code to mapOf(
            StringKey.TITLE to "你有多喜欢？",
            StringKey.RESULT to "调查结果",
            StringKey.RESTART to "重新开始",
            StringKey.COPY_LINK to "复制结果链接",
            StringKey.COPIED to "链接已复制！",
            StringKey.FOOD_KIMCHI_STEW to "泡菜汤",
            StringKey.FOOD_BIBIMBAP to "拌饭",
            StringKey.FOOD_BULGOGI to "烤牛肉",
            StringKey.FOOD_PORK_BELLY to "五花肉",
            StringKey.FOOD_SOYBEAN_STEW to "大酱汤",
            "responses" to mapOf(
                ResponseKey.HATE to "绝对不吃",
                ResponseKey.DISLIKE to "不太喜欢",
                ResponseKey.NEUTRAL to "一般",
                ResponseKey.LIKE to "喜欢",
                ResponseKey.LOVE to "非常喜欢"
            )
        ),
        Language.JAPANESE.code to mapOf(
            StringKey.TITLE to "どのくらい好きですか？",
            StringKey.RESULT to "回答結果",
            StringKey.RESTART to "もう一度",
            StringKey.COPY_LINK to "結果リンクをコピー",
            StringKey.COPIED to "リンクがコピーされました！",
            StringKey.FOOD_KIMCHI_STEW to "キムチチゲ",
            StringKey.FOOD_BIBIMBAP to "ビビンバ",
            StringKey.FOOD_BULGOGI to "プルコギ",
            StringKey.FOOD_PORK_BELLY to "サムギョプサル",
            StringKey.FOOD_SOYBEAN_STEW to "テンジャンチゲ",
            "responses" to mapOf(
                ResponseKey.HATE to "絶対に食べない",
                ResponseKey.DISLIKE to "あまり好きじゃない",
                ResponseKey.NEUTRAL to "普通",
                ResponseKey.LIKE to "好き",
                ResponseKey.LOVE to "大好き"
            )
        ),
        Language.TURKISH.code to mapOf(
            StringKey.TITLE to "Ne kadar seviyorsun?",
            StringKey.RESULT to "Anket Sonuçları",
            StringKey.RESTART to "Yeniden Başla",
            StringKey.COPY_LINK to "Sonuç Bağlantısını Kopyala",
            StringKey.COPIED to "Bağlantı kopyalandı!",
            StringKey.FOOD_KIMCHI_STEW to "Kimçi Çorbası",
            StringKey.FOOD_BIBIMBAP to "Bibimbap",
            StringKey.FOOD_BULGOGI to "Bulgogi",
            StringKey.FOOD_PORK_BELLY to "Izgara Domuz Eti",
            StringKey.FOOD_SOYBEAN_STEW to "Soya Fasulyesi Çorbası",
            "responses" to mapOf(
                ResponseKey.HATE to "Asla yemem",
                ResponseKey.DISLIKE to "Pek sevmiyorum",
                ResponseKey.NEUTRAL to "Fena değil",
                ResponseKey.LIKE to "Seviyorum",
                ResponseKey.LOVE to "Çok seviyorum"
            )
        ),
        Language.INDONESIAN.code to mapOf(
            StringKey.TITLE to "Seberapa suka?",
            StringKey.RESULT to "Hasil Survei",
            StringKey.RESTART to "Mulai Ulang",
            StringKey.COPY_LINK to "Salin Tautan Hasil",
            StringKey.COPIED to "Tautan disalin!",
            StringKey.FOOD_KIMCHI_STEW to "Sup Kimchi",
            StringKey.FOOD_BIBIMBAP to "Bibimbap",
            StringKey.FOOD_BULGOGI to "Bulgogi",
            StringKey.FOOD_PORK_BELLY to "Samgyeopsal",
            StringKey.FOOD_SOYBEAN_STEW to "Sup Pasta Kedelai",
            "responses" to mapOf(
                ResponseKey.HATE to "Sangat tidak suka",
                ResponseKey.DISLIKE to "Tidak suka",
                ResponseKey.NEUTRAL to "Biasa saja",
                ResponseKey.LIKE to "Suka",
                ResponseKey.LOVE to "Sangat suka"
            )
        )
    )

    fun getString(lang: Language, key: StringKey): String {
        return translations[lang.code]?.get(key) as? String ?: ""
    }

    fun getResponseString(lang: Language, key: ResponseKey): String {
        return (translations[lang.code]?.get("responses") as? Map<*, *>)?.get(key) as? String ?: ""
    }
}