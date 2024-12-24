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
import kotlinx.browser.window
import kotlin.js.Promise

@Composable
fun CopyLinkButton(responses: Map<String, String>) {
    var showCopySuccess by remember { mutableStateOf(false) }

    Button(
        onClick = {
            umami.track("copy")
            val shareUrl = URLUtils.encodeResponsesToURL(responses)
            window.navigator.clipboard.writeText(shareUrl).then { _ ->
                showCopySuccess = true
                Promise.resolve(null)
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