package com.peeksup.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.peeksup.util.URLUtils
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource


@Composable
fun FoodSurveyApp() {
    val urlResponses = remember { URLUtils.decodeURLToResponses("") }

    var currentFoodIndex by rememberSaveable { mutableStateOf(0) }
    var responses by rememberSaveable { mutableStateOf(urlResponses ?: emptyMap()) }
    var showResults by rememberSaveable { mutableStateOf(urlResponses != null) }

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (!showResults) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp)
            ) {
                Text(
                    text = "이거 어때?",
                    style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )

                FoodItem(
                    food = foodList[currentFoodIndex],
                    onOptionSelected = { selectedOption ->
                        responses = responses + (foodList[currentFoodIndex].name to selectedOption)
                        if (currentFoodIndex < foodList.size - 1) {
                            currentFoodIndex += 1
                        } else {
                            showResults = true
                        }
                    }
                )

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ResponseOptions(
                        options = responseOptions,
                        onOptionSelected = { selectedOption ->
                            responses = responses + (foodList[currentFoodIndex].name to selectedOption)
                            if (currentFoodIndex < foodList.size - 1) {
                                currentFoodIndex += 1
                            } else {
                                showResults = true
                            }
                        }
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize().padding(bottom = 80.dp)
            ) {
                Text(
                    text = "응답 결과",
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally)
                )
                ResultsDisplay(results = responses)
                Spacer(modifier = Modifier.height(16.dp))

                CopyLinkButton(responses = responses)

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        responses = emptyMap()
                        currentFoodIndex = 0
                        showResults = false
                        window.history.replaceState(null, "", window.location.pathname)
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "다시 시작", color = Color.White)
                }            }
        }
    }
}