package com.example.design_system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.design_system.BlackColor
import com.example.design_system.Poppins
import com.example.design_system.Primary
import com.example.design_system.R
import com.example.design_system.YellowColor

@Composable
fun CustomViewed(
    textSize: Int = 15,
    iconSize: Int = 18,
    modifier: Modifier = Modifier,
    isRtl: Boolean = true
) {
    if (isRtl) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Card(modifier = Modifier
                .wrapContentSize(),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Primary.copy(alpha = 0.2f)
                )
            ) {
                Row(modifier = Modifier
                    .wrapContentSize()
                    .padding(
                        horizontal = 10.dp,
                        vertical = 2.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    CustomText(
                        text = "1.3K",
                        fontSize = textSize,
                        color = Primary,
                        fontFamily = Poppins,
                        modifier = modifier
                    )
                    Icon(
                        modifier = Modifier.size(iconSize.dp),
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = null,
                        tint = Primary
                    )
                }
            }
        }
    } else {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Card(modifier = Modifier
                .wrapContentSize(),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Primary.copy(alpha = 0.2f)
                )
            ) {
                Row(modifier = Modifier
                    .wrapContentSize()
                    .padding(
                        horizontal = 10.dp,
                        vertical = 0.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    CustomText(
                        text = "1.1K",
                        fontSize = textSize,
                        color = Primary,
                        fontFamily = Poppins
                    )
                    Icon(
                        modifier = Modifier.size(iconSize.dp),
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = null,
                        tint = Primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_CustomViewed() {
    CustomViewed(
        textSize = 15,
        iconSize = 18,
        isRtl = true
    )
}