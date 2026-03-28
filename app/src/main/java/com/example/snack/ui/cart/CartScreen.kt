package com.example.snack.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.snack.data.OrderLine

@Composable
fun CartScreen(
    onCheckoutClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = hiltViewModel()
) {
    val orderLines by viewModel.orderLines.collectAsStateWithLifecycle()
    val total = orderLines.sumOf { it.snack.price * it.count }

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Carrito",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(orderLines, key = { it.snack.id }) { orderLine ->
                CartItem(
                    orderLine = orderLine,
                    onIncrease = { viewModel.increaseSnackCount(orderLine.snack.id) },
                    onDecrease = { viewModel.decreaseSnackCount(orderLine.snack.id) },
                    onRemove = { viewModel.removeSnack(orderLine.snack.id) }
                )
            }
        }
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainerHigh,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Total:", style = MaterialTheme.typography.titleLarge)
                    Text(
                        text = "$${total / 100.0}",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                // AÑADIDO: Botón para iniciar el flujo de pago
                Button(
                    onClick = onCheckoutClick,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    enabled = orderLines.isNotEmpty() // Solo habilitado si hay items
                ) {
                    Text("Proceder al pago")
                }
            }
        }
    }
}

@Composable
private fun CartItem(
    orderLine: OrderLine,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = orderLine.snack.imageUrl,
            contentDescription = orderLine.snack.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(80.dp).clip(CircleShape).background(MaterialTheme.colorScheme.surfaceVariant)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = orderLine.snack.name, style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = "$${orderLine.snack.price / 100.0}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 8.dp)) {
                IconButton(onClick = onDecrease, modifier = Modifier.size(32.dp)) { Icon(Icons.Default.Remove, "Quitar") }
                Text(text = "${orderLine.count}", modifier = Modifier.padding(horizontal = 16.dp))
                IconButton(onClick = onIncrease, modifier = Modifier.size(32.dp)) { Icon(Icons.Default.Add, "Agregar") }
            }
        }
        IconButton(onClick = onRemove) {
            Icon(Icons.Default.Close, contentDescription = "Eliminar", tint = MaterialTheme.colorScheme.error)
        }
    }
}