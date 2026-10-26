package ru.dayone.kotlinmodule2

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import ru.dayone.kotlinmodule2.ui.theme.KotlinModule2Theme

data class Cart(val products: List<Product>) {
    val totalSum: Int get() = products.sumOf { it.price }
    val hasFreeDelivery: Boolean get() = totalSum > 500
}

data class Product(val id: Int, val name: String, val price: Int)

private val CartSaver = listSaver<Cart, Any>(
    save = { cart -> cart.products.flatMap { listOf(it.id, it.name, it.price) } },
    restore = { values ->
        Cart(values.chunked(3).map { Product(it[0] as Int, it[1] as String, it[2] as Int) })
    },
)

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    var cart by rememberSaveable(stateSaver = CartSaver) {
        mutableStateOf(
            Cart(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56),
                ),
            ),
        )
    }
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Корзина", style = MaterialTheme.typography.headlineLarge)
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(cart.products, key = { it.id }) { product ->
                Text("${product.name} - ${product.price} рублей")
            }
            if (cart.products.isEmpty()) {
                item { Text("Корзина пуста") }
            }
        }
        Text("Товаров на сумму: ${cart.totalSum} рублей")
        AddProductSection {
            val id = (cart.products.maxOfOrNull { it.id } ?: -1) + 1
            val newCart = cart.copy(
                products = cart.products + Product(id, "Товар #${id + 1}", Random.nextInt(0, 100)),
            )
            cart = newCart
            // Toast относится к событию добавления, а не к отрисовке экрана.
            if (newCart.hasFreeDelivery) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }
        if (cart.products.isNotEmpty()) {
            RemoveProductSection {
                cart = cart.copy(products = cart.products.dropLast(1))
            }
        }
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) {
        Text("Добавить товар")
    }
}

@Composable
fun RemoveProductSection(onRemove: () -> Unit) {
    OutlinedButton(onClick = onRemove) {
        Text("Удалить товар")
    }
}

@Preview(showBackground = true)
@Composable
fun Task10Preview() {
    KotlinModule2Theme {
        ShoppingCartScreen()
    }
}
