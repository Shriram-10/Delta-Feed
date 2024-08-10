package com.example.delta_feed

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val name = mutableStateOf("Ansh Gujral")
val postFollowFollowing = mutableStateOf(listOf(25, 500, 200))
val displayPicture = mutableStateOf(R.drawable.john)
var posts = listOf (R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image2, R.drawable.image1, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image2, R.drawable.image1)
var pronoun = mutableStateOf("he/him")

@Composable
fun ProfilePage (
    navController : NavController,
    displayProfile : Int,
    images : List<Int>
) {
    val colors = MaterialTheme.colorScheme

    Scaffold (
        topBar = { DeltaTopAppBar() },
        bottomBar = { DeltaBottomAppBar(navController = navController) }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image (
                    painter = painterResource (id = displayProfile),
                    contentDescription = "Display Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp)
                )

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text (
                        text = postFollowFollowing.value[0].toString(),
                        color = colors.onBackground,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text (
                        text = "posts",
                        color = colors.onBackground,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text (
                        text = postFollowFollowing.value[1].toString(),
                        color = colors.onBackground,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text (
                        text = "followers",
                        color = colors.onBackground,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text (
                        text = postFollowFollowing.value[2].toString(),
                        color = colors.onBackground,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text (
                        text = "following",
                        color = colors.onBackground,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Row {
                Text (
                    text = name.value,
                    color = colors.onBackground,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 20.dp, top = 12.dp),
                    fontWeight = FontWeight.Bold
                )

                Text (
                    text = " ${pronoun.value}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 12.dp),
                    fontWeight = FontWeight.Normal
                )
            }

            Text (
                text = "May the force be with you.",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 4.dp, start = 20.dp, bottom = 20.dp),
                fontWeight = FontWeight.Normal
            )

            HorizontalLine(modifier = Modifier.fillMaxWidth(), start = 0f, end = 1f)

            LazyVerticalGrid (
                columns = GridCells.Fixed(3)
            ) {
                items (10) { i ->
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(150.dp)
                            .border(BorderStroke(1.dp, colors.onBackground))
                    ) {
                        Image (
                            painter = painterResource(images[i]),
                            contentDescription = "Images",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}