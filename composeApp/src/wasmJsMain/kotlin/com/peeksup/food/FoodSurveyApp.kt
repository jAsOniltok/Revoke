package com.peeksup.food

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.peeksup.util.LanguageManager
import com.peeksup.util.FoodResponseKey
import com.peeksup.util.ResponseKey
import com.peeksup.util.StringKey
import com.peeksup.util.SurveyItems
import com.peeksup.util.SurveyType
import com.peeksup.util.URLUtils
import com.peeksup.util.isWasmGCSupported
import com.peeksup.util.umami
import kotlinx.browser.window


@Composable
fun SurveyApp(surveyType: SurveyType) {
    if(isWasmGCSupported().not()){
        BrowserCompatibilityWarning()
    } else {
        val urlDecodedResult = remember {
            try {
                URLUtils.decodeURLToResponses("").also {
                    println("URL Responses: $it")
                }
            } catch (e: Exception) {
                println("URL decode error: $e")
                null
            }
        }

        // URL에서 타입과 응답을 분리
        val (decodedType, urlResponses) = urlDecodedResult ?: (surveyType to emptyMap())

        val responseOptions = remember {
            ResponseKey.getByType(surveyType).map { key ->
                LanguageManager.getResponseString(key)
            }
        }

        var currentIndex by rememberSaveable { mutableStateOf(0) }
        var responses by rememberSaveable { mutableStateOf(urlResponses) }
        var showResults by rememberSaveable { mutableStateOf(urlResponses.isNotEmpty()) }

        val items = SurveyItems.getItemsByType(surveyType)

        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            if (!showResults) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp)
                ) {
                    SurveyItem(
                        modifier = Modifier.weight(1f, false),
                        item = items[currentIndex]
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ResponseOptions(
                            options = responseOptions,
                            onOptionSelected = { selectedOption ->
                                val itemName = LanguageManager.getString(items[currentIndex].stringKey)
                                umami.track("${itemName to selectedOption}")
                                responses = responses + (itemName to selectedOption)
                                if (currentIndex < items.size - 1) {
                                    currentIndex += 1
                                } else {
                                    showResults = true
                                }
                            }
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 140.dp)
                    ) {
                        Text(
                            text = LanguageManager.getString(StringKey.RESULT),
                            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        ResultsDisplay(
                            surveyType = surveyType,
                            results = responses,
                            modifier = Modifier
                        )
                    }

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(bottom = 16.dp)
                    ) {
                        CopyLinkButton(surveyType = surveyType, responses = responses)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {
                                umami.track("retry")
                                responses = emptyMap()
                                currentIndex = 0
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
                            Text(text = LanguageManager.getString(StringKey.RESTART), color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
