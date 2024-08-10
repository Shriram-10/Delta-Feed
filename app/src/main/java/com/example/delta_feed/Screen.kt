package com.example.delta_feed

sealed class Screen (val route: String) {
    object Home : Screen ("home")

    object Profile : Screen ("profile")
}