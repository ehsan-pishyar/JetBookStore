package com.example.parstasmimcodechallengeep.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigation.Screens

@Composable
fun AppNavigation(
    navHostController: NavHostController
) {
    NavHost(
        route = "route",
        navController = navHostController,
        startDestination = Screens.Search.route
    ) {
        composable(route = Screens.Splash.route) {

        }
        composable(route = Screens.Home.route) {

        }
        composable(route = Screens.Search.route) {

        }
        composable(route = Screens.Details.route) {

        }
        composable(route = Screens.AddBook.route) {

        }
    }
}