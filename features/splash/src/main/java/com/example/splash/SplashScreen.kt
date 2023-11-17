package com.example.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.design_system.Background
import com.example.design_system.R
import com.example.design_system.components.CustomSpacer
import com.example.design_system.components.CustomText
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    toHomeScreen: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        toHomeScreen()
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.parstasmim_logo),
                contentDescription = null
            )
            CustomSpacer()
            CustomText(
                text = "پارس تصمیم",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun Preview_SplashScreen() {
    SplashScreen(
        toHomeScreen = {}
    )
}