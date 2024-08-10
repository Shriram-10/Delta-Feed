package com.example.delta_feed

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeltaTopAppBar () {
    val colors = MaterialTheme.colorScheme
    TopAppBar (
        title = {
            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image (
                        painter = painterResource(id = R.drawable.deltalogo),
                        contentDescription = "Delta Logo",
                        modifier = Modifier
                            .scale(0.7f),
                        colorFilter = ColorFilter.tint(colors.onBackground, BlendMode.SrcIn)
                    )

                    Text (
                        text = "DELTA FEED",
                        letterSpacing = 6.sp,
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                        fontSize = 28.sp,
                        color = colors.onBackground
                    )
                }

            }
        },

        modifier = Modifier
            .shadow(elevation = 8.dp, shape = RectangleShape)
            .padding(0.dp)

    )
}