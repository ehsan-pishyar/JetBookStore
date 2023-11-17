package com.example.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.SharedViewModel
import com.example.navigation.Screens

fun NavGraphBuilder.detailsScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = Screens.Details.route
    ) {
        DetailsScreen(
            sharedViewModel = sharedViewModel,
            toSearchScreen = { navController.navigate(Screens.Search.route) },
            toHomeScreen = { navController.navigate(Screens.Home.route) },
            toAddBookScreen = { navController.navigate(Screens.AddBook.route) }
        )
    }
}