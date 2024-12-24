package com.peeksup.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

@Composable
fun FoodItem(food: Food, onOptionSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(food.imageRes),
            contentDescription = food.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // 이미지 크기 증가
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = food.name,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .align(Alignment.CenterHorizontally), // 중앙 정렬,
            textAlign = TextAlign.Center
        )
    }
}
