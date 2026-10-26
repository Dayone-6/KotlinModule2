package ru.dayone.kotlinmodule2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dayone.kotlinmodule2.ui.theme.KotlinModule2Theme

@Composable
fun WaterTracker(modifier: Modifier = Modifier) {
    var waterCount by rememberSaveable { mutableIntStateOf(100) }
    var successfulDays by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(Modifier.height(48.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary,
        )
        Spacer(Modifier.height(24.dp))
        Button(onClick = { waterCount += 250 }) {
            Text(text = "+250 мл", fontSize = 18.sp)
        }
        Spacer(Modifier.height(12.dp))
        OutlinedButton(
            onClick = {
                successfulDays = if (waterCount >= 1500) successfulDays + 1 else 0
                waterCount = 0
            },
        ) {
            Text("Завершить день")
        }
        Spacer(Modifier.height(24.dp))
        Text("Дней подряд с 1500 мл и больше: $successfulDays")
    }
}

@Preview(showBackground = true)
@Composable
fun Task8Preview() {
    KotlinModule2Theme {
        WaterTracker()
    }
}
