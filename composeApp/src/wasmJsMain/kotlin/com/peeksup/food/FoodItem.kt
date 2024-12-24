package com.peeksup.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.peeksup.util.LanguageManager
import org.jetbrains.compose.resources.painterResource

@Composable
fun FoodItem(food: Food) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(food.imageRes),
            contentDescription = LanguageManager.getString(food.stringKey),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = LanguageManager.getString(food.stringKey),
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}