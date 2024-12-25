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
    FOOD_SOYBEAN_STEW,

    BROWSER_WARNING_TITLE,
    BROWSER_SUPPORTED_TITLE,
    BROWSER_SUPPORTED_LIST,
    BROWSER_LEGACY_TITLE,
    BROWSER_LEGACY_LIST
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
            ),
            StringKey.BROWSER_WARNING_TITLE to "최신 브라우저가 필요합니다",
            StringKey.BROWSER_SUPPORTED_TITLE to "지원되는 브라우저:",
            StringKey.BROWSER_SUPPORTED_LIST to "• Chrome 119+ (자동 지원)\n" +
                    "• 크로미움 기반 브라우저 119+ (자동 지원):\n" +
                    "  - Microsoft Edge\n" +
                    "  - Brave\n" +
                    "  - Whale(네이버)\n" +
                    "  - Opera\n" +
                    "  - Vivaldi\n" +
                    "  - Samsung Internet\n" +
                    "  - Arc\n" +
                    "• Firefox 120+ (자동 지원)\n" +
                    "• Safari/WebKit 18.2+ (자동 지원)",
            StringKey.BROWSER_LEGACY_TITLE to "이전 버전에서 사용하기:",
            StringKey.BROWSER_LEGACY_LIST to "• Chrome: chrome://flags에서 'WebAssembly GC' 활성화\n" +
                    "• Firefox 119: about:config에서 'javascript.options.wasm_gc' 활성화\n" +
                    "• Safari 18.2 미만: 지원되지 않음"
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
            ),
            StringKey.BROWSER_WARNING_TITLE to "Modern Browser Required",
            StringKey.BROWSER_SUPPORTED_TITLE to "Supported Browsers:",
            StringKey.BROWSER_SUPPORTED_LIST to "• Chrome 119+ (automatically supported)\n" +
                    "• Chromium-based browsers 119+ (automatically supported):\n" +
                    "  - Microsoft Edge\n" +
                    "  - Brave\n" +
                    "  - Whale (Naver)\n" +
                    "  - Opera\n" +
                    "  - Vivaldi\n" +
                    "  - Samsung Internet\n" +
                    "  - Arc\n" +
                    "• Firefox 120+ (automatically supported)\n" +
                    "• Safari/WebKit 18.2+ (automatically supported)",
            StringKey.BROWSER_LEGACY_TITLE to "For older versions:",
            StringKey.BROWSER_LEGACY_LIST to "• Chrome: Enable 'WebAssembly GC' in chrome://flags\n" +
                    "• Firefox 119: Enable 'javascript.options.wasm_gc' in about:config\n" +
                    "• Safari below 18.2: Not supported"
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
            ),
            StringKey.BROWSER_WARNING_TITLE to "需要现代浏览器",
            StringKey.BROWSER_SUPPORTED_TITLE to "支持的浏览器：",
            StringKey.BROWSER_SUPPORTED_LIST to "• Chrome 119+（自动支持）\n" +
                    "• Chromium基本浏览器 119+（自动支持）：\n" +
                    "  - Microsoft Edge\n" +
                    "  - Brave\n" +
                    "  - Whale（Naver）\n" +
                    "  - Opera\n" +
                    "  - Vivaldi\n" +
                    "  - Samsung Internet\n" +
                    "  - Arc\n" +
                    "• Firefox 120+（自动支持）\n" +
                    "• Safari/WebKit 18.2+（自动支持）",
            StringKey.BROWSER_LEGACY_TITLE to "较旧版本设置：",
            StringKey.BROWSER_LEGACY_LIST to "• Chrome：在chrome://flags中启用'WebAssembly GC'\n" +
                    "• Firefox 119：在about:config中启用'javascript.options.wasm_gc'\n" +
                    "• Safari 18.2以下：不支持"
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
            ),
            StringKey.BROWSER_WARNING_TITLE to "最新のブラウザが必要です",
            StringKey.BROWSER_SUPPORTED_TITLE to "対応ブラウザ：",
            StringKey.BROWSER_SUPPORTED_LIST to "• Chrome 119+（自動対応）\n" +
                    "• Chromiumベースのブラウザ 119+（自動対応）：\n" +
                    "  - Microsoft Edge\n" +
                    "  - Brave\n" +
                    "  - Whale（Naver）\n" +
                    "  - Opera\n" +
                    "  - Vivaldi\n" +
                    "  - Samsung Internet\n" +
                    "  - Arc\n" +
                    "• Firefox 120+（自動対応）\n" +
                    "• Safari/WebKit 18.2+（自動対応）",
            StringKey.BROWSER_LEGACY_TITLE to "古いバージョンの設定：",
            StringKey.BROWSER_LEGACY_LIST to "• Chrome：chrome://flagsで'WebAssembly GC'を有効化\n" +
                    "• Firefox 119：about:configで'javascript.options.wasm_gc'を有効化\n" +
                    "• Safari 18.2未満：非対応"
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
            ),
            StringKey.BROWSER_WARNING_TITLE to "Modern Tarayıcı Gerekli",
            StringKey.BROWSER_SUPPORTED_TITLE to "Desteklenen Tarayıcılar:",
            StringKey.BROWSER_SUPPORTED_LIST to "• Chrome 119+ (otomatik desteklenir)\n" +
                    "• Chromium tabanlı tarayıcılar 119+ (otomatik desteklenir):\n" +
                    "  - Microsoft Edge\n" +
                    "  - Brave\n" +
                    "  - Whale (Naver)\n" +
                    "  - Opera\n" +
                    "  - Vivaldi\n" +
                    "  - Samsung Internet\n" +
                    "  - Arc\n" +
                    "• Firefox 120+ (otomatik desteklenir)\n" +
                    "• Safari/WebKit 18.2+ (otomatik desteklenir)",
            StringKey.BROWSER_LEGACY_TITLE to "Eski sürümler için:",
            StringKey.BROWSER_LEGACY_LIST to "• Chrome: chrome://flags'de 'WebAssembly GC'yi etkinleştirin\n" +
                    "• Firefox 119: about:config'de 'javascript.options.wasm_gc'yi etkinleştirin\n" +
                    "• Safari 18.2 altı: Desteklenmiyor"
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
            ),
            StringKey.BROWSER_WARNING_TITLE to "Browser Modern Diperlukan",
            StringKey.BROWSER_SUPPORTED_TITLE to "Browser yang Didukung:",
            StringKey.BROWSER_SUPPORTED_LIST to "• Chrome 119+ (didukung secara otomatis)\n" +
                    "• Browser berbasis Chromium 119+ (didukung otomatis):\n" +
                    "  - Microsoft Edge\n" +
                    "  - Brave\n" +
                    "  - Whale (Naver)\n" +
                    "  - Opera\n" +
                    "  - Vivaldi\n" +
                    "  - Samsung Internet\n" +
                    "  - Arc\n" +
                    "• Firefox 120+ (didukung otomatis)\n" +
                    "• Safari/WebKit 18.2+ (didukung otomatis)",
            StringKey.BROWSER_LEGACY_TITLE to "Untuk versi lama:",
            StringKey.BROWSER_LEGACY_LIST to "• Chrome: Aktifkan 'WebAssembly GC' di chrome://flags\n" +
                    "• Firefox 119: Aktifkan 'javascript.options- Firefox 119: Aktifkan 'javascript.options.wasm_gc' di about:config\n" +
                    "• Safari di bawah 18.2: Tidak didukung"
        )
    )

    fun getString(lang: Language, key: StringKey): String {
        return translations[lang.code]?.get(key) as? String ?: ""
    }

    fun getResponseString(lang: Language, key: ResponseKey): String {
        return (translations[lang.code]?.get("responses") as? Map<*, *>)?.get(key) as? String ?: ""
    }
}