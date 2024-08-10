package com.example.delta_feed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation () {
    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable (
            route = Screen.Home.route
        ) {
            HomePage (navController)
        }

        composable (
            route = Screen.Profile.route
        ) {
            ProfilePage (navController, displayPicture.value, posts)
        }
    }
}