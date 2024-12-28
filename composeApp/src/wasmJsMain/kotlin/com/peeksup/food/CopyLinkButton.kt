package com.peeksup.food

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.peeksup.util.LanguageManager
import com.peeksup.util.StringKey
import com.peeksup.util.SurveyType
import com.peeksup.util.URLUtils
import com.peeksup.util.umami
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLTextAreaElement
import kotlin.js.Promise

@Composable
fun CopyLinkButton(surveyType: SurveyType,responses: Map<String, String>) {
    var showCopySuccess by remember { mutableStateOf(false) }

    Button(
        onClick = {
            val shareUrl = URLUtils.encodeResponsesToURL(surveyType, responses)
            umami.track("copy")

            try {
                window.navigator.clipboard.writeText(shareUrl).then { _ ->
                    showCopySuccess = true
                    umami.track("copy_modern_success")
                    Promise.resolve(null)
                }.catch { error ->
                    val textArea = document.createElement("textarea") as HTMLTextAreaElement
                    textArea.value = shareUrl
                    textArea.setAttribute("readonly", "")
                    textArea.style.position = "fixed"
                    textArea.style.left = "0"
                    textArea.style.top = "0"
                    textArea.style.opacity = "0"

                    document.body?.appendChild(textArea)
                    textArea.focus()
                    textArea.select()

                    try {
                        val success = document.execCommand("copy")
                        showCopySuccess = success
                        umami.track(if (success) "copy_fallback_success" else "copy_fallback_failed")
                    } finally {
                        document.body?.removeChild(textArea)
                    }

                    Promise.resolve(null)  // catch 블록에서 Promise 반환
                }
            } catch (e: Exception) {
                umami.track("copy_initial_failed")
            }
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4CAF50)),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = if (showCopySuccess) LanguageManager.getString(StringKey.COPIED) else LanguageManager.getString(StringKey.COPY_LINK),
            color = Color.White
        )
    }
}