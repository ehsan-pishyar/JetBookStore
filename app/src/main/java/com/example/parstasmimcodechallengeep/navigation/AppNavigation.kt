package com.example.parstasmimcodechallengeep.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.add_book.addBookScreen
import com.example.details.detailsScreen
import com.example.home.homeScreen
import com.example.navigation.Screens
import com.example.search.searchScreen
import com.example.splash.splashScreen

@Composable
fun AppNavigation(
    navHostController: NavHostController
) {
    NavHost(
        route = "route",
        navController = navHostController,
        startDestination = Screens.Search.route
    ) {
        splashScreen(navController = navHostController)
        homeScreen(navController = navHostController)
        searchScreen(navController = navHostController)
        detailsScreen(navController = navHostController)
        addBookScreen(navController = navHostController)
    }
}