package com.example.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Screens

fun NavGraphBuilder.searchScreen(
    navController: NavController
) {
    composable(
        route = Screens.Search.route
    ) {
        SearchScreen()
    }
}