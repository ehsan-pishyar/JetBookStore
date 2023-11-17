package com.example.design_system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.design_system.Poppins
import com.example.design_system.Primary

@Composable
fun CustomButton(
    text: String,
    color: Color = Primary,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        CustomText(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 12
        )
    }
}

@Composable
fun CustomFadeButton(
    text: String = "",
    containerColor: Color = Color.White.copy(alpha = 0.2f),
    textColor: Color = Color.White
) {
    Card(modifier = Modifier
        .wrapContentSize(),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Column(modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 10.dp, vertical = 3.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(
                text = text,
                fontFamily = Poppins,
                fontSize = 12,
                color = textColor
            )
        }
    }
}

@Preview
@Composable
private fun Preview_CustomFadeButton() {
    CustomFadeButton(
        text = "checked out"
    )
}

@Preview
@Composable
private fun Preview_CustomButton() {
    CustomButton(text = "افزودن") {}
}