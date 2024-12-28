package com.peeksup.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.peeksup.util.CelebrityItem
import com.peeksup.util.LanguageManager
import com.peeksup.util.SurveyItem
import org.jetbrains.compose.resources.painterResource

@Composable
fun SurveyItem(modifier: Modifier, item: SurveyItem) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(item.imageRes),
            contentDescription = LanguageManager.getString(item.stringKey),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f, false)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = LanguageManager.getString(item.stringKey),
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 12.dp),
            textAlign = TextAlign.Center
        )
    }
}