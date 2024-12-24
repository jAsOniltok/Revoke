package com.peeksup.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.peeksup.util.umami
import org.jetbrains.compose.resources.painterResource

@Composable
fun ResultsDisplay(results: Map<String, String>) {
    // 응답별로 음식 그룹화
    val groupedResults = results.entries.groupBy { it.value }
    umami.track("results", groupedResults.toString())

    // Scrollable Column으로 전체 내용을 스크롤 가능하게 함
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // 스크롤 추가
    ) {
        groupedResults.forEach { (response, foods) ->
            // 응답 카테고리 헤더
            Text(
                text = response,
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )

            // 음식 리스트 표시
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                foods.forEach { (foodName, _) ->
                    FoodResultItem(foodName = foodName)
                }
            }
        }
    }
}

@Composable
fun FoodResultItem(foodName: String) {
    // 해당 음식의 이미지 리소스 찾기
    val food = foodList.find { it.name == foodName }

    if (food != null) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 음식 이미지
            Image(
                painter = painterResource(food.imageRes),
                contentDescription = food.name,
                modifier = Modifier
                    .size(80.dp) // 이미지 크기 확대
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // 음식 이름
            Text(
                text = food.name,
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Medium),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
