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
import com.peeksup.util.URLUtils
import com.peeksup.util.umami
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLTextAreaElement
import kotlin.js.Promise

@Composable
fun CopyLinkButton(responses: Map<String, String>) {
    var showCopySuccess by remember { mutableStateOf(false) }

    Button(
        onClick = {
            umami.track("copy")
            val shareUrl = URLUtils.encodeResponsesToURL(responses)

            try {
                // Clipboard API 시도
                window.navigator.clipboard.writeText(shareUrl).then { _ ->
                    showCopySuccess = true
                    Promise.resolve(null)
                }
            } catch (e: Exception) {
                println("Clipboard API 실패: $e")

                try {
                    // 가장 기본적인 방식으로 시도
                    val textArea = document.createElement("textarea") as HTMLTextAreaElement
                    textArea.value = shareUrl

                    // 화면 밖으로 이동
                    textArea.style.position = "absolute"
                    textArea.style.left = "-9999px"

                    document.body?.appendChild(textArea)
                    textArea.focus()
                    textArea.select()

                    val success = document.execCommand("copy")
                    document.body?.removeChild(textArea)

                    showCopySuccess = success
                } catch (e: Exception) {
                    println("execCommand 실패: $e")
                    umami.track("웹뷰 복사 실패 $e")
                }
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