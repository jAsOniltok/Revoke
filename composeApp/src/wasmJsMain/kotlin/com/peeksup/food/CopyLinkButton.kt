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
                // Modern API 시도
                window.navigator.clipboard.writeText(shareUrl).then { _ ->
                    showCopySuccess = true
                    Promise.resolve(null)
                }
            } catch (e: Exception) {
                println("클립보드 접근 실패 $e")
                val shareUrl2 = URLUtils.encodeResponsesToURL(responses)

                val textArea = document.createElement("textarea") as HTMLTextAreaElement
                textArea.value = shareUrl2
                document.body?.appendChild(textArea)
                textArea.select()

                try {
                    showCopySuccess = document.execCommand("copy")
                } catch (e: Exception) {
                    println(e)
                } finally {
                    document.body?.removeChild(textArea)
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