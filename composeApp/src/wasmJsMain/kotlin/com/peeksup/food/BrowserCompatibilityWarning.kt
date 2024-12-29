package com.peeksup.food

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.peeksup.util.LanguageManager
import com.peeksup.util.StringKey
import com.peeksup.util.umami

@Composable
fun BrowserCompatibilityWarning() {
    LaunchedEffect(Unit) {
        umami.track("BrowserCompatibilityWarning")
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = LanguageManager.getString(StringKey.BROWSER_WARNING_TITLE),
            textAlign = TextAlign.Center
        )
        Text(
            text = LanguageManager.getString(StringKey.BROWSER_SUPPORTED_TITLE),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = LanguageManager.getString(StringKey.BROWSER_SUPPORTED_LIST),
            textAlign = TextAlign.Center
        )
    }
}