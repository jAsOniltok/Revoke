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

data class Food(
    val stringKey: StringKey,  // FoodKey 대신 StringKey 사용
    val imageRes: DrawableResource,
    var selectedOption: String = ""
)

val foodList = listOf(
    Food(StringKey.FOOD_KIMCHI_STEW, Res.drawable.kimch_1),
    Food(StringKey.FOOD_BIBIMBAP, Res.drawable.bibim_1),
    Food(StringKey.FOOD_BULGOGI, Res.drawable.bul_1),
    Food(StringKey.FOOD_PORK_BELLY, Res.drawable.sam_1),
    Food(StringKey.FOOD_SOYBEAN_STEW, Res.drawable.ehls_1)
)