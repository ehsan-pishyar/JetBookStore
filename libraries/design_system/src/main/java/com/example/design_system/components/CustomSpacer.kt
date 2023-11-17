package com.example.design_system.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacer(
    space: Int = 20
) {
    Spacer(modifier = Modifier.height(space.dp))
}