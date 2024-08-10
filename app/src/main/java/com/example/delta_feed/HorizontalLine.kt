package com.example.delta_feed

import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun HorizontalLine (
    modifier: Modifier,
    start : Float,
    end : Float,
    width : Float = 4f
) {
    val color = MaterialTheme.colorScheme
    Canvas (
        modifier = modifier
    ) {
        drawLine (
            color = color.onBackground,
            start = Offset(size.width * start, size.height / 2),
            end = Offset(size.width * end, size.height / 2),
            strokeWidth = width
        )
    }
}

@Composable
fun HollowCircle (
    modifier : Modifier,
    width : Float = 6f,
    color : Color = MaterialTheme.colorScheme.onBackground
) {
    val colors = MaterialTheme.colorScheme
    Canvas (
        modifier = modifier
    ) {
        drawCircle (
            radius = size.width / 2,
            color = color,
            center = Offset(size.width / 2, size.height / 2),
            style = Stroke(width = width)
        )
    }
}

@Composable
fun VerticalLine (
    modifier: Modifier,
    start : Float,
    end : Float,
    width : Float = 4f
){
    val color = MaterialTheme.colorScheme
    Canvas (
        modifier = modifier
    ) {
        drawLine (
            color = color.onBackground,
            start = Offset(size.width * start, size.height / 2),
            end = Offset(size.width * end, size.height / 2),
            strokeWidth = width
        )
    }
}