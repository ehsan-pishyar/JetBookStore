package com.example.navigation

sealed class Screens (val route: String) {
    object Splash: Screens (route = "splash")
    object Home: Screens (route = "home")
    object Search: Screens (route = "search")
    object AddBook: Screens (route = "add_book")
    object Details: Screens (route = "details")
}