package com.example.delta_feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeedCard (
    modifier : Modifier = Modifier,
    images : List<Int>,
    userId : List<String>,
    displayProfile : List<Int>,
    goToProfile : () -> Unit,
    pronouns : List<String>
) {
    Column (
        modifier.padding(top = 0.dp),
    ) {
        CardHead (
            modifier = Modifier.padding(top = 24.dp),
            userId = userId,
            displayProfile = displayProfile,
            goToProfile = goToProfile,
            pronouns = pronouns
        )

        ScrollableImages(images = images)

        HorizontalLine(modifier = Modifier.fillMaxWidth(), start = 0f, end = 1f, width = 4f)
    }
}

@Composable
fun CardHead (
    modifier : Modifier,
    userId : List<String>,
    displayProfile : List<Int>,
    goToProfile: () -> Unit,
    pronouns: List<String>
) {
    val colors = MaterialTheme.colorScheme

    Column (
        modifier = modifier
    ) {
        HorizontalLine(modifier = Modifier.fillMaxWidth(), start = 0f, end = 1f, width = 4f)

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box (
                contentAlignment = Alignment.Center,
            ) {
                displayProfile.forEach { i ->
                    Image (
                        painter = painterResource(id = displayProfile[0]),
                        contentDescription = "Display Profile",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .clip(CircleShape)
                            .height(36.dp),
                        colorFilter = ColorFilter.tint(colors.onBackground, BlendMode.SrcIn)
                    )

                    HollowCircle (
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            userId.forEach { user ->
                Text (
                    text = user,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable {
                            name.value = user
                            pronoun.value = pronouns[0]
                            displayPicture.value = displayProfile[0]
                            postFollowFollowing.value = listOf(78, 600, 800)
                            goToProfile()
                        },
                    color = colors.onBackground,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    letterSpacing = 1.sp
                )

                if (userId.size > 1 && userId.indexOf(user) != userId.size - 1) {
                    Text (
                        text = " &",
                        modifier = Modifier.padding(start = 4.dp),
                        color = colors.onBackground,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }

        HorizontalLine(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp), start = 0f, end = 1f, width = 4f)
    }
}