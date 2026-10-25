package ru.dayone.kotlinmodule2

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp),
        border = BorderStroke(2.dp, Color.Gray),
        shape = RoundedCornerShape(16.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Color.LightGray
        ),
    ) {
        Text(
            text = "Нажми на меня",
            color = Color.Black,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonPreview() {
    MyButton()
}