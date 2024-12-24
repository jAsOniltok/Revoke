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
import com.peeksup.util.LanguageManager
import com.peeksup.util.umami
import org.jetbrains.compose.resources.painterResource

@Composable
fun ResultsDisplay(modifier: Modifier, results: Map<String, String>) {
    val groupedResults = results.entries.groupBy { it.value }
    umami.track("results", groupedResults.toString())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        groupedResults.forEach { (response, foods) ->
            Text(
                text = response,
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )

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
    // stringKey로 Food 찾기
    val food = foodList.find { LanguageManager.getString(it.stringKey) == foodName }

    if (food != null) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(food.imageRes),
                contentDescription = LanguageManager.getString(food.stringKey),
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = LanguageManager.getString(food.stringKey),
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Medium),
                modifier = Modifier.weight(1f)
            )
        }
    }
}