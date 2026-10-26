package ru.dayone.kotlinmodule2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Task71() {
    Column {
        Text("Имя: Евгений")
        Text("Отчество: Юрьевич")
        Text("Фамилия: Лукашин")
        Text("Мобильный телефон: +7999999999")
        Text("Адрес: г. Москва, ул. Пушкина")
    }
}

@Preview(showSystemUi = true)
@Composable
fun Task71Preview() {
    Task71()
}

data class Item(
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val phone: String,
    val address: String,
)

@Composable
fun Task72() {
    val items = listOf(
        Item(
            "Евгений",
            "Андреевич",
            "Лукашин",
            "+7 999 999 99 99",
            "г. Москва, ул. "
        ),
        Item(
            "Евгений",
            "Андреевич",
            "Лукашин",
            "+7 999 999 99 99",
            "г. Москва, ул. "
        ),
        Item(
            "Евгений",
            "Андреевич",
            "Лукашин",
            "+7 999 999 99 99",
            "г. Москва, ул. "
        ),
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Имя: ${it.firstName}")
                Text("Отчество: ${it.middleName}")
                Text("Фамилия: ${it.lastName}")
                Text("Мобильный телефон: ${it.phone}")
                Text("Адрес: ${it.address}")
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Task72Preview() {
    Task72()
}

@Composable
fun Task73() {
    Box(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Имя: Евгений")
                Text("Отчество: Юрьевич")
                Text("Фамилия: Лукашин")
                Text("Мобильный телефон: +7999999999")
                Text("Адрес: г. Москва, ул. Пушкина")
            }

            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Task73Preview() {
    Task73()
}