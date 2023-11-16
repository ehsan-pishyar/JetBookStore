package com.example.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Screens

fun NavGraphBuilder.detailsScreen(
    navController: NavController
) {
    composable(
        route = Screens.Details.route
    ) {
        DetailsScreen()
    }
}