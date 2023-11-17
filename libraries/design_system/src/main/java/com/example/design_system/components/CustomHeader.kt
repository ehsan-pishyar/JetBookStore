package com.example.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.design_system.BlackColor
import com.example.design_system.Primary
import com.example.design_system.R

@Composable
fun CustomHeader(
    hasBackButton: Boolean = false,
    toSearchScreen: () -> Unit,
    darkStyle: Boolean = false
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(55.dp)
        .background(Color.Transparent)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (darkStyle) {
                Card(modifier = Modifier
                    .size(40.dp)
                    .clickable(enabled = true, onClick = { toSearchScreen() }),
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Primary.copy(alpha = 0.2f)
                    )
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = BlackColor
                        )
                    }
                }
                if (hasBackButton) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = BlackColor
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = BlackColor
                    )
                }
            } else {
                Card(modifier = Modifier
                    .size(40.dp)
                    .clickable(enabled = true, onClick = { toSearchScreen() }),
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.2f)
                    )
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }
                if (hasBackButton) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color.White
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_CustomHeader() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        CustomHeader(
            hasBackButton = false,
            toSearchScreen = {}
        )
    }
}