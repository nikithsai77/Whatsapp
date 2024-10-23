package com.android.whatsapp.ui.theme.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextComponent(text: String, fontSize: TextUnit, color: Color, fontWeight: FontWeight) {
    Text(text = text, style = TextStyle(fontSize = fontSize, color = color, fontWeight = fontWeight))
}