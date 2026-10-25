package ru.dayone.kotlinmodule2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import ru.dayone.kotlinmodule2.ui.theme.KotlinModule2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinModule2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Hello(null)
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = name?.let { "Hello, $name" } ?: "Name has not been provided"
        )
    }
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true,
)
fun HelloPreviewPortrait() {
    Hello("Leonid")
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true, device = "spec:parent=pixel_5,orientation=landscape",
)
fun HelloPreviewLandscape() {
    Hello("Leonid")
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:width=200dp,height=200dp,dpi=320,isRound=true",
    backgroundColor = 0xffffff00,
)
fun HelloPreviewRound() {
    Hello("Leonid")
}