package com.example.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.SharedViewModel
import com.example.navigation.Screens

fun NavGraphBuilder.searchScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = Screens.Search.route
    ) {
        SearchScreen(
            sharedViewModel = sharedViewModel,
            toDetailsScreen = { navController.navigate(Screens.Details.route) }
        )
    }
}