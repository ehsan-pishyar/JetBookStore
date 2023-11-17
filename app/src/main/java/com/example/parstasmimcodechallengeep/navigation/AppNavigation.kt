package com.example.parstasmimcodechallengeep.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.add_book.addBookScreen
import com.example.core.SharedViewModel
import com.example.details.detailsScreen
import com.example.home.homeScreen
import com.example.navigation.Screens
import com.example.search.searchScreen
import com.example.splash.splashScreen

@Composable
fun AppNavigation(
    navHostController: NavHostController
) {
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        route = "route",
        navController = navHostController,
        startDestination = Screens.Splash.route
    ) {
        splashScreen(navController = navHostController)
        homeScreen(
            sharedViewModel = sharedViewModel,
            navController = navHostController
        )
        searchScreen(
            sharedViewModel = sharedViewModel,
            navController = navHostController
        )
        detailsScreen(
            sharedViewModel = sharedViewModel,
            navController = navHostController
        )
        addBookScreen(navController = navHostController)
    }
}