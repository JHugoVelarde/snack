package com.example.snack.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.snack.data.FilterOption
import kotlin.collections.first

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipBar(
    options: List<FilterOption>,
    modifier: Modifier = Modifier
) {
    // Estado local para saber qué filtro está seleccionado (solo uno a la vez)
    var selectedOption by remember { mutableStateOf<FilterOption?>(options.first()) }

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // El icono de filtro a la izquierda
        item {
            IconButton(onClick = { /* Abrir panel de filtros */ }) {
                Icon(Icons.Default.FilterList, contentDescription = "Filtros", tint = MaterialTheme.colorScheme.primary)
            }
        }
        // Las opciones de filtro
        items(options) { option ->
            FilterChip(
                selected = selectedOption == option,
                onClick = { selectedOption = option },
                label = { Text(option.label) }
            )
        }
    }
}