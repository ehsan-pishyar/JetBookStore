package com.example.design_system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import com.example.design_system.R
import com.example.design_system.YellowColor

@Composable
fun CustomRating(
    rate: Float? = null,
    textSize: Int = 15,
    iconSize: Int = 18,
    modifier: Modifier = Modifier,
    isRtl: Boolean = true
) {
    if (isRtl) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(modifier = Modifier
                .wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                CustomText(
                    text = "$rate",
                    fontSize = textSize,
                    color = BlackColor,
                    fontFamily = Poppins,
                    modifier = modifier
                )
                Icon(
                    modifier = Modifier.size(iconSize.dp),
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    tint = YellowColor
                )
            }
        }
    } else {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Row(modifier = Modifier
                .wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                CustomText(
                    text = "$rate",
                    fontSize = textSize,
                    color = BlackColor,
                    fontFamily = Poppins,
                    modifier = modifier
                )
                Icon(
                    modifier = Modifier.size(iconSize.dp),
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    tint = YellowColor
                )
            }
        }
    }

}

@Preview
@Composable
private fun Preview_CustomRating() {
    CustomRating(
        rate = 4.5f,
        textSize = 15,
        iconSize = 18,
        isRtl = true
    )
}