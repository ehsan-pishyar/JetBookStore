package com.example.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Screens

fun NavGraphBuilder.splashScreen(
    navController: NavController
) {
    composable(
        route = Screens.Splash.route
    ) {
        SplashScreen()
    }
}