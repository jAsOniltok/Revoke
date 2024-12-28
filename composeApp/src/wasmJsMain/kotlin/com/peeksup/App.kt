package com.peeksup

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontFamily
import com.peeksup.food.SurveyApp
import com.peeksup.util.SurveyType
import com.peeksup.util.umami
import kotlinx.browser.window
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
        SurveyApp(SurveyType.CELEBRITY)
    }
}
