package com.peeksup.util

import org.jetbrains.compose.resources.DrawableResource
import revoke.composeapp.generated.resources.Res
import revoke.composeapp.generated.resources.bibim_1
import revoke.composeapp.generated.resources.bws_1
import revoke.composeapp.generated.resources.cew_1
import revoke.composeapp.generated.resources.cyr_1
import revoke.composeapp.generated.resources.gd_1
import revoke.composeapp.generated.resources.iu_1
import revoke.composeapp.generated.resources.iu_2
import revoke.composeapp.generated.resources.jk_1
import revoke.composeapp.generated.resources.jn_1
import revoke.composeapp.generated.resources.jwy_1
import revoke.composeapp.generated.resources.kimch_1
import revoke.composeapp.generated.resources.krn_1
import revoke.composeapp.generated.resources.rose_1
import revoke.composeapp.generated.resources.wt_1

// 1. 설문 종류
enum class SurveyType {
    FOOD,
    CELEBRITY
}

// 2. 언어
enum class Language(val code: String) {
    KOREAN("ko"),
    ENGLISH("en"),
    CHINESE("zh"),
    JAPANESE("ja"),
    TURKISH("tr"),
    INDONESIAN("id")
}

// 3. 공통 문자열 키
enum class StringKey {
    // App Common
    TITLE,
    RESULT,
    RESTART,
    COPY_LINK,
    COPIED,

    // Browser Support
    BROWSER_WARNING_TITLE,
    BROWSER_SUPPORTED_TITLE,
    BROWSER_SUPPORTED_LIST,
    BROWSER_LEGACY_TITLE,
    BROWSER_LEGACY_LIST,

    // Foods
    FOOD_KIMCHI_STEW,
    FOOD_BIBIMBAP,
    FOOD_BULGOGI,
    FOOD_PORK_BELLY,
    FOOD_SOYBEAN_STEW,

    // Celebrities
    아이유,
    변우석,
    차은우,
    조유리,
    GD,
    정국,
    제니,
    장원영,
    카리나,
    로제,
    윈터,
}

sealed interface ResponseKey {
    // 공통 상태를 관리하는 companion object
    companion object {
        fun getByType(type: SurveyType): Array<out ResponseKey> = when (type) {
            SurveyType.FOOD -> FoodResponseKey.entries.toTypedArray()
            SurveyType.CELEBRITY -> CelebrityResponseKey.entries.toTypedArray()
        }
    }
}

enum class FoodResponseKey : ResponseKey {
    HATE,
    DISLIKE,
    NEUTRAL,
    LIKE,
    LOVE
}

enum class CelebrityResponseKey : ResponseKey {
    DONT_KNOW,
    DISLIKE,
    NEUTRAL,
    LIKE,
    LOVE
}

// 5. 설문 아이템 기본 클래스
sealed class SurveyItem(
    val type: SurveyType,
    val stringKey: StringKey,
    val imageRes: DrawableResource
) {
    fun getResponseKeys(): Array<out ResponseKey> = when (type) {
        SurveyType.FOOD -> FoodResponseKey.entries.toTypedArray()
        SurveyType.CELEBRITY -> CelebrityResponseKey.entries.toTypedArray()
    }
}

class FoodItem(
    stringKey: StringKey,
    imageRes: DrawableResource
) : SurveyItem(SurveyType.FOOD, stringKey, imageRes)

class CelebrityItem(
    stringKey: StringKey,
    imageRes: DrawableResource
) : SurveyItem(SurveyType.CELEBRITY, stringKey, imageRes)

object SurveyItems {
    val foodList = listOf(
        FoodItem(StringKey.FOOD_KIMCHI_STEW, Res.drawable.kimch_1),
        FoodItem(StringKey.FOOD_BIBIMBAP, Res.drawable.bibim_1),
        // 나머지 음식들은 그대로 유지
    )

    val celebrityList = listOf(
        CelebrityItem(StringKey.변우석, Res.drawable.bws_1),
        CelebrityItem(StringKey.차은우, Res.drawable.cew_1),
        CelebrityItem(StringKey.조유리, Res.drawable.cyr_1),
        CelebrityItem(StringKey.GD, Res.drawable.gd_1),
        CelebrityItem(StringKey.아이유, Res.drawable.iu_2),
        CelebrityItem(StringKey.정국, Res.drawable.jk_1),
        CelebrityItem(StringKey.제니, Res.drawable.jn_1),
        CelebrityItem(StringKey.장원영, Res.drawable.jwy_1),
        CelebrityItem(StringKey.카리나, Res.drawable.krn_1),
        CelebrityItem(StringKey.로제, Res.drawable.rose_1),
        CelebrityItem(StringKey.윈터, Res.drawable.wt_1),
    )

    fun getItemsByType(type: SurveyType) = when(type) {
        SurveyType.FOOD -> foodList
        SurveyType.CELEBRITY -> celebrityList
    }
}

private val koreanTranslations = mapOf(
    StringKey.TITLE to "얼마나 좋아하세요?",
    StringKey.RESULT to "응답 결과",
    StringKey.RESTART to "다시 시작",
    StringKey.COPY_LINK to "결과 링크 복사하기",
    StringKey.COPIED to "링크가 복사되었습니다!",

    // Foods
    StringKey.FOOD_KIMCHI_STEW to "김치찌개",
    StringKey.FOOD_BIBIMBAP to "비빔밥",
    StringKey.FOOD_BULGOGI to "불고기",
    StringKey.FOOD_PORK_BELLY to "삼겹살",
    StringKey.FOOD_SOYBEAN_STEW to "된장찌개",

    // Celebrities
    StringKey.아이유 to "아이유",
    StringKey.변우석 to "변우석",
    StringKey.차은우 to "차은우",
    StringKey.조유리 to "조유리",
    StringKey.GD to "GD",
    StringKey.정국 to "정국",
    StringKey.제니 to "제니",
    StringKey.장원영 to "장원영",
    StringKey.카리나 to "카리나",
    StringKey.로제 to "로제",
    StringKey.윈터 to "윈터",

    // Browser Support
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
            "• Safari 18.2 미만: 지원되지 않음",

    "food_responses" to mapOf(
        FoodResponseKey.HATE to "절대 안(못)먹어",
        FoodResponseKey.DISLIKE to "별로 안좋아해",
        FoodResponseKey.NEUTRAL to "보통이야",
        FoodResponseKey.LIKE to "좋아해",
        FoodResponseKey.LOVE to "엄청 좋아해"
    ),
    "celebrity_responses" to mapOf(
        CelebrityResponseKey.DONT_KNOW to "잘 몰라",
        CelebrityResponseKey.DISLIKE to "딱히 안 좋아해",
        CelebrityResponseKey.NEUTRAL to "괜찮다",
        CelebrityResponseKey.LIKE to "좋아해",
        CelebrityResponseKey.LOVE to "완전 많이 좋아해"
    )
)
private val englishTranslations = mapOf(
    StringKey.TITLE to "How much do you like it?",
    StringKey.RESULT to "Survey Results",
    StringKey.RESTART to "Start Over",
    StringKey.COPY_LINK to "Copy Result Link",
    StringKey.COPIED to "Link copied!",

    // Foods
    StringKey.FOOD_KIMCHI_STEW to "Kimchi Stew",
    StringKey.FOOD_BIBIMBAP to "Bibimbap",
    StringKey.FOOD_BULGOGI to "Bulgogi",
    StringKey.FOOD_PORK_BELLY to "Pork Belly",
    StringKey.FOOD_SOYBEAN_STEW to "Soybean Paste Stew",

    // Celebrities
    StringKey.아이유 to "아이유",
    StringKey.변우석 to "변우석",
    StringKey.차은우 to "차은우",
    StringKey.조유리 to "조유리",
    StringKey.GD to "GD",
    StringKey.정국 to "정국",
    StringKey.제니 to "제니",
    StringKey.장원영 to "장원영",
    StringKey.카리나 to "카리나",
    StringKey.로제 to "로제",
    StringKey.윈터 to "윈터",

    // Browser Support
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
            "• Safari below 18.2: Not supported",

    "food_responses" to mapOf(
        FoodResponseKey.HATE to "Hate it",
        FoodResponseKey.DISLIKE to "Don't like it",
        FoodResponseKey.NEUTRAL to "It's okay",
        FoodResponseKey.LIKE to "Like it",
        FoodResponseKey.LOVE to "Love it"
    ),
    "celebrity_responses" to mapOf(
        CelebrityResponseKey.DONT_KNOW to "I Don't know",
        CelebrityResponseKey.DISLIKE to "I Don't like",
        CelebrityResponseKey.NEUTRAL to "They're okay",
        CelebrityResponseKey.LIKE to "I Like",
        CelebrityResponseKey.LOVE to "I Love!!"
    )
)

private val chineseTranslations = mapOf(
    StringKey.TITLE to "你有多喜欢？",
    StringKey.RESULT to "调查结果",
    StringKey.RESTART to "重新开始",
    StringKey.COPY_LINK to "复制结果链接",
    StringKey.COPIED to "链接已复制！",

    // Foods
    StringKey.FOOD_KIMCHI_STEW to "泡菜汤",
    StringKey.FOOD_BIBIMBAP to "拌饭",
    StringKey.FOOD_BULGOGI to "烤牛肉",
    StringKey.FOOD_PORK_BELLY to "五花肉",
    StringKey.FOOD_SOYBEAN_STEW to "大酱汤",

    // Celebrities
    StringKey.아이유 to "아이유",
    StringKey.변우석 to "변우석",
    StringKey.차은우 to "차은우",
    StringKey.조유리 to "조유리",
    StringKey.GD to "GD",
    StringKey.정국 to "정국",
    StringKey.제니 to "제니",
    StringKey.장원영 to "장원영",
    StringKey.카리나 to "카리나",
    StringKey.로제 to "로제",
    StringKey.윈터 to "윈터",

    // Browser Support
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
            "• Safari 18.2以下：不支持",

    "food_responses" to mapOf(
        FoodResponseKey.HATE to "绝对不吃",
        FoodResponseKey.DISLIKE to "不太喜欢",
        FoodResponseKey.NEUTRAL to "一般",
        FoodResponseKey.LIKE to "喜欢",
        FoodResponseKey.LOVE to "非常喜欢"
    ),
    "celebrity_responses" to mapOf(
        CelebrityResponseKey.DONT_KNOW to "不认识",
        CelebrityResponseKey.DISLIKE to "不喜欢",
        CelebrityResponseKey.NEUTRAL to "一般",
        CelebrityResponseKey.LIKE to "喜欢",
        CelebrityResponseKey.LOVE to "非常喜欢"
    )
)

private val japaneseTranslations = mapOf(
    StringKey.TITLE to "どのくらい好きですか？",
    StringKey.RESULT to "回答結果",
    StringKey.RESTART to "もう一度",
    StringKey.COPY_LINK to "結果リンクをコピー",
    StringKey.COPIED to "リンクがコピーされました！",

    // Foods
    StringKey.FOOD_KIMCHI_STEW to "キムチチゲ",
    StringKey.FOOD_BIBIMBAP to "ビビンバ",
    StringKey.FOOD_BULGOGI to "プルコギ",
    StringKey.FOOD_PORK_BELLY to "サムギョプサル",
    StringKey.FOOD_SOYBEAN_STEW to "テンジャンチゲ",

    // Celebrities
    StringKey.아이유 to "아이유",
    StringKey.변우석 to "변우석",
    StringKey.차은우 to "차은우",
    StringKey.조유리 to "조유리",
    StringKey.GD to "GD",
    StringKey.정국 to "정국",
    StringKey.제니 to "제니",
    StringKey.장원영 to "장원영",
    StringKey.카리나 to "카리나",
    StringKey.로제 to "로제",
    StringKey.윈터 to "윈터",

    // Browser Support
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
            "• Safari 18.2未満：非対応",

    "food_responses" to mapOf(
        FoodResponseKey.HATE to "絶対に食べない",
        FoodResponseKey.DISLIKE to "あまり好きじゃない",
        FoodResponseKey.NEUTRAL to "普通",
        FoodResponseKey.LIKE to "好き",
        FoodResponseKey.LOVE to "大好き"
    ),
    "celebrity_responses" to mapOf(
        CelebrityResponseKey.DONT_KNOW to "知らない",
        CelebrityResponseKey.DISLIKE to "好きじゃない",
        CelebrityResponseKey.NEUTRAL to "普通",
        CelebrityResponseKey.LIKE to "好き",
        CelebrityResponseKey.LOVE to "大好き"
    )
)

private val turkishTranslations = mapOf(
    StringKey.TITLE to "Ne kadar seviyorsun?",
    StringKey.RESULT to "Anket Sonuçları",
    StringKey.RESTART to "Yeniden Başla",
    StringKey.COPY_LINK to "Sonuç Bağlantısını Kopyala",
    StringKey.COPIED to "Bağlantı kopyalandı!",

    // Foods
    StringKey.FOOD_KIMCHI_STEW to "Kimçi Çorbası",
    StringKey.FOOD_BIBIMBAP to "Bibimbap",
    StringKey.FOOD_BULGOGI to "Bulgogi",
    StringKey.FOOD_PORK_BELLY to "Izgara Domuz Eti",
    StringKey.FOOD_SOYBEAN_STEW to "Soya Fasulyesi Çorbası",

    // Celebrities
    StringKey.아이유 to "아이유",
    StringKey.변우석 to "변우석",
    StringKey.차은우 to "차은우",
    StringKey.조유리 to "조유리",
    StringKey.GD to "GD",
    StringKey.정국 to "정국",
    StringKey.제니 to "제니",
    StringKey.장원영 to "장원영",
    StringKey.카리나 to "카리나",
    StringKey.로제 to "로제",
    StringKey.윈터 to "윈터",

    // Browser Support
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
            "• Safari 18.2 altı: Desteklenmiyor",

    "food_responses" to mapOf(
        FoodResponseKey.HATE to "Asla yemem",
        FoodResponseKey.DISLIKE to "Pek sevmiyorum",
        FoodResponseKey.NEUTRAL to "Fena değil",
        FoodResponseKey.LIKE to "Seviyorum",
        FoodResponseKey.LOVE to "Çok seviyorum"
    ),
    "celebrity_responses" to mapOf(
        CelebrityResponseKey.DONT_KNOW to "Tanımıyorum",
        CelebrityResponseKey.DISLIKE to "Sevmiyorum",
        CelebrityResponseKey.NEUTRAL to "Fena değil",
        CelebrityResponseKey.LIKE to "Seviyorum",
        CelebrityResponseKey.LOVE to "Çok seviyorum"
    )
)

private val indonesianTranslations = mapOf(
    StringKey.TITLE to "Seberapa suka?",
    StringKey.RESULT to "Hasil Survei",
    StringKey.RESTART to "Mulai Ulang",
    StringKey.COPY_LINK to "Salin Tautan Hasil",
    StringKey.COPIED to "Tautan disalin!",

    // Foods
    StringKey.FOOD_KIMCHI_STEW to "Sup Kimchi",
    StringKey.FOOD_BIBIMBAP to "Bibimbap",
    StringKey.FOOD_BULGOGI to "Bulgogi",
    StringKey.FOOD_PORK_BELLY to "Samgyeopsal",
    StringKey.FOOD_SOYBEAN_STEW to "Sup Pasta Kedelai",

    // Celebrities
    StringKey.아이유 to "아이유",
    StringKey.변우석 to "변우석",
    StringKey.차은우 to "차은우",
    StringKey.조유리 to "조유리",
    StringKey.GD to "GD",
    StringKey.정국 to "정국",
    StringKey.제니 to "제니",
    StringKey.장원영 to "장원영",
    StringKey.카리나 to "카리나",
    StringKey.로제 to "로제",
    StringKey.윈터 to "윈터",

    // Browser Support
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
            "• Firefox 119: Aktifkan 'javascript.options.wasm_gc' di about:config\n" +
            "• Safari di bawah 18.2: Tidak didukung",

    "food_responses" to mapOf(
        FoodResponseKey.HATE to "Sangat tidak suka",
        FoodResponseKey.DISLIKE to "Tidak suka",
        FoodResponseKey.NEUTRAL to "Biasa saja",
        FoodResponseKey.LIKE to "Suka",
        FoodResponseKey.LOVE to "Sangat suka"
    ),
    "celebrity_responses" to mapOf(
        CelebrityResponseKey.DONT_KNOW to "Tidak kenal",
        CelebrityResponseKey.DISLIKE to "Tidak suka",
        CelebrityResponseKey.NEUTRAL to "Biasa saja",
        CelebrityResponseKey.LIKE to "Suka",
        CelebrityResponseKey.LOVE to "Sangat suka"
    )
)

object Strings {
    private val translations = mapOf(
        Language.KOREAN.code to koreanTranslations,
        Language.ENGLISH.code to englishTranslations,
        Language.CHINESE.code to chineseTranslations,
        Language.JAPANESE.code to japaneseTranslations,
        Language.TURKISH.code to turkishTranslations,
        Language.INDONESIAN.code to indonesianTranslations
    )

    fun getString(lang: Language, key: StringKey): String {
        return translations[lang.code]?.get(key) as? String ?: ""
    }

    fun getResponseString(lang: Language, key: ResponseKey): String {
        val responseKey = when(key) {
            is FoodResponseKey -> "food_responses"
            is CelebrityResponseKey -> "celebrity_responses"
        }

        return (translations[lang.code]?.get(responseKey) as? Map<*, *>)?.get(key) as? String ?: ""
    }
}