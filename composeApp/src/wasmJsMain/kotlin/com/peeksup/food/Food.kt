package com.peeksup.food

import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.DrawableResource
import revoke.composeapp.generated.resources.Res
import revoke.composeapp.generated.resources.bibim_1
import revoke.composeapp.generated.resources.bul_1
import revoke.composeapp.generated.resources.ehls_1
import revoke.composeapp.generated.resources.kimch_1
import revoke.composeapp.generated.resources.sam_1

data class Food(
    val name: String,
    val imageRes: DrawableResource, // 이미지 리소스 ID 추가
    var selectedOption: String = ""
)

val foodList = listOf(
    Food("김치찌개", Res.drawable.kimch_1),
    Food("비빔밥", Res.drawable.bibim_1),
    Food("불고기", Res.drawable.bul_1),
    Food("삼겹살", Res.drawable.sam_1),
    Food("된장찌개", Res.drawable.ehls_1)
)

val responseOptions = listOf(
    "절대 안(못)먹어",
    "별로 안좋아해",
    "보통이야",
    "좋아해",
    "엄청 좋아해"
)
