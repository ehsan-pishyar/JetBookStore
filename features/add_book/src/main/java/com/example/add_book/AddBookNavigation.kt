package com.example.add_book

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Screens

fun NavGraphBuilder.addBookScreen(
    navController: NavController
) {
    composable(
        route = Screens.AddBook.route
    ) {
        AddBookScreen()
    }
}