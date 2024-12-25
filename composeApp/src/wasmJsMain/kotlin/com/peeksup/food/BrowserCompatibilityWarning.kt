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
            "최신 브라우저가 필요합니다",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "다음 브라우저에서 접속해주세요:\n\n" +
                    "• Chrome 또는 크로미움 기반 브라우저 119+\n" +
                    "• Firefox 120+\n\n" +
                    "모바일에서도 위 버전의 브라우저로\n" +
                    "접속 가능합니다",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}