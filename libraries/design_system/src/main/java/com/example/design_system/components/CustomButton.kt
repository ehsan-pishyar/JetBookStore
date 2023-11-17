package com.example.design_system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.design_system.Poppins

@Composable
fun CustomButton() {
    
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