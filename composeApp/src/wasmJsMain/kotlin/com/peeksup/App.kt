package com.peeksup

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontFamily
import com.peeksup.food.FoodSurveyApp
import com.peeksup.util.umami
import org.jetbrains.compose.resources.Font
import revoke.composeapp.generated.resources.Pretendard_SemiBold
import revoke.composeapp.generated.resources.Res

@Composable
fun App() {
    val font = Font(Res.font.Pretendard_SemiBold)

    LaunchedEffect(Unit) {
        umami.track("App Initializing")
    }

    MaterialTheme(
        typography = Typography(
            FontFamily(font)
        )
    ) {
        FoodSurveyApp()
    }
}