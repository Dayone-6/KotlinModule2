package ru.dayone.kotlinmodule2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Task6() {
    Box(
        modifier = Modifier.width(240.dp).height(120.dp).background(Color.Blue),
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center).fillMaxSize(),
            painter = painterResource(R.drawable.ic_circle),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Magenta)
        )
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun Task6Preview() {
    Task6()
}