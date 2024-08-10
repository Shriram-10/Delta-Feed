package com.example.delta_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomePage (navController : NavController) {
    Scaffold (
        topBar = {
            DeltaTopAppBar()
        },
        bottomBar = {
            DeltaBottomAppBar(navController = navController)
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = innerPadding.calculateBottomPadding(),
                    top = innerPadding.calculateTopPadding()
                )
        ) {
            LazyColumn {
                item {
                    Column  {
                        FeedCard (
                            images = listOf (R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image2, R.drawable.image1),
                            modifier = Modifier.padding(bottom = 24.dp),
                            userId = listOf("delta_nitt"),
                            displayProfile = listOf(R.drawable.deltalogo),
                            goToProfile = { navController.navigate(Screen.Profile.route) },
                            pronouns = listOf("they/them")
                        )

                        FeedCard (
                            images = listOf (R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image2, R.drawable.image1),
                            modifier = Modifier.padding(bottom = 24.dp),
                            userId = listOf("don_wick", "_selvanayagam_"),
                            displayProfile = listOf(R.drawable.john),
                            goToProfile = { navController.navigate(Screen.Profile.route) },
                            pronouns = listOf("he/him", "he/him")
                        )
                    }
                }
            }
        }
    }
}