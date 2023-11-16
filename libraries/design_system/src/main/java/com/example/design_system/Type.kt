package com.example.design_system

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val IranYekan = FontFamily(
    Font(R.font.iranyekan_regular, FontWeight.Normal),
    Font(R.font.iranyekan_medium, FontWeight.Medium),
    Font(R.font.iranyekan_bold, FontWeight.Bold),
    Font(R.font.iranyekan_black, FontWeight.Black)
)