package com.peeksup.food

import androidx.compose.ui.graphics.painter.Painter
import com.peeksup.util.StringKey
import org.jetbrains.compose.resources.DrawableResource
import revoke.composeapp.generated.resources.Res
import revoke.composeapp.generated.resources.bibim_1
import revoke.composeapp.generated.resources.bul_1
import revoke.composeapp.generated.resources.ehls_1
import revoke.composeapp.generated.resources.kimch_1
import revoke.composeapp.generated.resources.sam_1

// FoodType.kt
enum class FoodType {
    KIMCHI_STEW,
    BIBIMBAP,
    BULGOGI,
    PORK_BELLY,
    SOYBEAN_STEW;

    // 이미지 리소스와 매핑
    val imageResource: DrawableResource
        get() = when (this) {
            KIMCHI_STEW -> Res.drawable.kimch_1
            BIBIMBAP -> Res.drawable.bibim_1
            BULGOGI -> Res.drawable.bul_1
            PORK_BELLY -> Res.drawable.sam_1
            SOYBEAN_STEW -> Res.drawable.ehls_1
        }

    // 번역 키와 매핑
    val translationKey: StringKey
        get() = when (this) {
            KIMCHI_STEW -> StringKey.FOOD_KIMCHI_STEW
            BIBIMBAP -> StringKey.FOOD_BIBIMBAP
            BULGOGI -> StringKey.FOOD_BULGOGI
            PORK_BELLY -> StringKey.FOOD_PORK_BELLY
            SOYBEAN_STEW -> StringKey.FOOD_SOYBEAN_STEW
        }
}

// Food.kt
data class Food(
    val type: FoodType,
    var selectedOption: String = ""
) {
    val imageRes: DrawableResource get() = type.imageResource
    val stringKey: StringKey get() = type.translationKey
}

// foodList 정의
val foodList = FoodType.values().map { Food(it) }