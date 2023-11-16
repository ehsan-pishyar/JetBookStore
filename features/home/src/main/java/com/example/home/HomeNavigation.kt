package com.example.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Screens

fun NavGraphBuilder.homeScreen(
    navController: NavController
) {
    composable(
        route = Screens.Home.route
    ) {
        HomeScreen()
    }
}