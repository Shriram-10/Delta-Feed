package com.example.delta_feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class BottomNavigationItem (
    val title: String,
    val route : String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

val items = listOf (
    BottomNavigationItem(
        route = Screen.Home.route,
        title = "Home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home
    ),

    BottomNavigationItem (
        route = Screen.Profile.route,
        title = "Profile",
        unselectedIcon = Icons.Outlined.AccountCircle,
        selectedIcon = Icons.Filled.AccountCircle
    )
)

@Composable
fun DeltaBottomAppBar (navController : NavController) {
    val colors = MaterialTheme.colorScheme

    NavigationBar (
        containerColor = colors.background,
        contentColor = colors.onBackground,
        modifier = Modifier.shadow(8.dp, shape = RectangleShape)
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NavigationBar(
                containerColor = Color.Transparent,
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton (
                        onClick = { navController.navigate(items[0].route) },
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Icon(
                            imageVector = if (navController.currentBackStackEntryAsState().value?.destination?.route == items[0].route) items[0].selectedIcon else items[0].unselectedIcon,
                            contentDescription = items[0].title,
                            modifier = Modifier.scale(1.2f),
                            tint = colors.onBackground
                        )
                    }

                    IconButton (
                        onClick = {
                            navController.navigate(items[1].route)

                        },
                        modifier = Modifier.padding(start = 16.dp)
                    ) {
                        Icon(
                            imageVector = if (navController.currentBackStackEntryAsState().value?.destination?.route == items[1].route) items[1].selectedIcon else items[1].unselectedIcon,
                            contentDescription = items[1].title,
                            modifier = Modifier.scale(1.2f),
                            tint = colors.onBackground
                        )
                    }
                }
            }
        }
    }
}