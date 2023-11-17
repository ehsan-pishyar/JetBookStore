package com.example.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.SharedViewModel
import com.example.navigation.Screens

fun NavGraphBuilder.homeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel? = null
) {
    composable(
        route = Screens.Home.route
    ) {
        HomeScreen(
            sharedViewModel = sharedViewModel!!,
            toSearchScreen = { navController.navigate(Screens.Search.route) },
            toDetailsScreen = { navController.navigate(Screens.Details.route) }
        )
    }
}