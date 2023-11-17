package com.example.design_system.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.design_system.BlackColor
import com.example.design_system.IranYekan

@Composable
fun CustomText(
    text: String,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = BlackColor,
    textAlign: TextAlign = TextAlign.Start,
    fontFamily: FontFamily = IranYekan,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    lineHeight: Double = 1.5,
    maxLines: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = (fontSize).sp,
        color = color,
        lineHeight = (lineHeight).em,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}