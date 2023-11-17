package com.example.design_system.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.design_system.Poppins
import com.example.design_system.R

@Composable
fun CustomBookListStyle(
    title: String = ""
) {
    Card(modifier = Modifier
        .width(250.dp)
        .height(170.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.book_image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
            )
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(
                    text = title,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    maxLines = 4
                )

                Row(modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomRating(
                        rate = 4.5f,
                        textSize = 11,
                        iconSize = 13,
                        modifier = Modifier.padding(top = 3.dp),
                        isRtl = true
                    )
                    CustomViewed(
                        textSize = 10,
                        iconSize = 13,
                        modifier = Modifier.padding(top = 3.dp),
                        isRtl = true
                    )
                }
            }
        }
    }
}

@Composable
fun CustomBookGridStyle(
    title: String
) {
    Card(modifier = Modifier
        .width(180.dp)
        .height(260.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.book_image),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(100.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                )
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(
                    text = title,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    fontSize = 13
                )

                Row(modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomRating(
                        rate = 4.5f,
                        textSize = 11,
                        iconSize = 13,
                        modifier = Modifier.padding(top = 3.dp),
                        isRtl = true
                    )
                    CustomViewed(
                        textSize = 10,
                        iconSize = 13,
                        modifier = Modifier.padding(top = 3.dp),
                        isRtl = true
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_CustomBookListStyle() {
    CustomBookListStyle(
        title = "Walk needs-based invoice payment blue"
    )
}

@Preview
@Composable
private fun Preview_CustomBookGridStyle() {
    CustomBookGridStyle(
        title = "Walk needs-based invoice payment blue"
    )
}