package com.peeksup.food

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.peeksup.util.URLUtils
import com.peeksup.util.umami
import kotlinx.browser.window


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
                )

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ResponseOptions(
                        options = responseOptions,
                        onOptionSelected = { selectedOption ->
                            umami.track("${foodList[currentFoodIndex].name to selectedOption}")
                            responses =
                                responses + (foodList[currentFoodIndex].name to selectedOption)
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
                        umami.track("retry")
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
                }
            }
        }
    }
}