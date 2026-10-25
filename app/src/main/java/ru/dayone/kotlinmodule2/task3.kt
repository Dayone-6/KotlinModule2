package ru.dayone.kotlinmodule2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
@Preview(
    showBackground = true,
)
fun Text1() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = stringResource(R.string.some_text),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
    )
}

@Composable
@Preview(
    showBackground = true,
)
fun Text2() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = stringResource(R.string.some_text),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
    )
}

@Composable
@Preview(
    showBackground = true,
)
fun Text3() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = stringResource(R.string.some_text),
        style = TextStyle(
            color = Color.Black,
            background = Color.Green,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline,
            textIndent = TextIndent(
                firstLine = 48.sp,
            )
        )
    )
}