package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.design_system.Background
import com.example.design_system.Primary
import com.example.design_system.carouselCheckedOutBooksSize
import com.example.design_system.components.CustomBookGridStyle
import com.example.design_system.components.CustomBookListStyle
import com.example.design_system.components.CustomFadeButton
import com.example.design_system.components.CustomHeader
import com.example.design_system.components.CustomText

@Composable
fun HomeScreen() {

}

@Composable
fun HomeContent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
            ) {
                Card(modifier = Modifier
                    .fillMaxSize(),
                    shape = RoundedCornerShape(bottomStart = 40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Primary
                    )
                ) {
                    // Header Section
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(10.dp)
                    ) {
                        CustomHeader(
                            hasBackButton = false,
                            toSearchScreen = {}
                        )
                    }
                    // Home description section
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 20.dp)
                    ) {
                        CustomText(
                            text = "چی میخوای بخونی؟",
                            fontSize = 25,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    // Checked out products Section
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        CustomFadeButton(
                            text = "Checked Out"
                        )
                    }

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f)
                        .padding(20.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        LazyRow(
                            contentPadding = PaddingValues(0.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            userScrollEnabled = true,
                            content = {
                                items(count = carouselCheckedOutBooksSize(4)) {
                                    CustomBookListStyle(
                                        title = "Walk needs-based invoice payment blue"
                                    )
                                }
                            }
                        )
                    }
                }
            }
            
            // All Books Section (Grid layout)
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .padding(20.dp)
            ) {
                // All Books title section
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    CustomText(
                        text = "همه کتاب ها",
                        fontSize = 20,
                        fontWeight = FontWeight.Bold
                    )
                }
                // All Books content section
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
                ) {
                    LazyRow(
                        contentPadding = PaddingValues(0.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        userScrollEnabled = true,
                        content = {
                            items(count = carouselCheckedOutBooksSize(4)) {
                                CustomBookGridStyle(
                                    title = "Walk needs-based invoice payment blue"
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_HomeContent() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        HomeContent()
    }
}