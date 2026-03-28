package com.example.snack.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.snack.ui.cart.CartScreen
import com.example.snack.ui.components.TiendaBottomBar
import com.example.snack.ui.profile.ProfileScreen
import com.example.snack.ui.search.SearchScreen

@Composable
fun Home(
    onSnackClick: (Long) -> Unit,
    onCheckoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: HomeSections.FEED.route

    Scaffold(
        bottomBar = {
            TiendaBottomBar(
                tabs = HomeSections.entries.toTypedArray(),
                currentRoute = currentRoute,
                navigateToRoute = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = HomeSections.FEED.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(HomeSections.FEED.route) {
                FeedScreen(onSnackClick = onSnackClick)
            }
            composable(HomeSections.SEARCH.route) { SearchScreen(
                onCategoryClick = { /* Navegar a lista filtrada (pendiente) */ }
            ) }
            composable(HomeSections.CART.route) { CartScreen(onCheckoutClick = onCheckoutClick) }
            composable(HomeSections.PROFILE.route) { ProfileScreen() }
        }
    }
}