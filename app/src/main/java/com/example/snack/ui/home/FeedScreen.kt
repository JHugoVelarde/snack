package com.example.snack.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.snack.data.FakeSnackData
import com.example.snack.data.FilterOption
import com.example.snack.ui.components.FeaturedSnackCard
import com.example.snack.ui.components.FilterChipBar
import com.example.snack.ui.components.PopularSnackCircle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredSnacks = FakeSnackData.featuredSnacks
    val popularSnacks = FakeSnackData.popularSnacks

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Entrega a 1600 Amphitheater Way", style = MaterialTheme.typography.titleMedium)
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Cambiar dirección")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                windowInsets = WindowInsets(0, 0, 0, 0)
            )
        },
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding() + 88.dp
            )
        ) {
            item {
                FilterChipBar(options = FilterOption.entries)
            }
            item {
                SectionHeader("Elegidos por Android")
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(featuredSnacks, key = { it.id }) { snack ->
                        FeaturedSnackCard(snack = snack, onClick = { onSnackClick(snack.id) })
                    }
                }
            }
            item {
                SectionHeader("Popular en Snack")
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(popularSnacks, key = { it.id }) { snack ->
                        PopularSnackCircle(snack = snack, onClick = { onSnackClick(snack.id) })
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.primary)
        IconButton(onClick = {}) {
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Ver todo", tint = MaterialTheme.colorScheme.primary)
        }
    }
}