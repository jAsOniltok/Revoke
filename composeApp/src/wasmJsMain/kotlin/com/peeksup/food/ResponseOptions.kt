package com.peeksup.food

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ResponseOptions(
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        options.forEach { option ->
            Button(
                onClick = { onOptionSelected(option) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFF8E1), // 연한 아이보리색
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp) // 버튼 크기 확대
                    .padding(horizontal = 4.dp), // 버튼 간 간격 조정
                shape = RoundedCornerShape(0.dp) // Radius 제거
            ) {
                Text(text = option)
            }
        }
    }
}
