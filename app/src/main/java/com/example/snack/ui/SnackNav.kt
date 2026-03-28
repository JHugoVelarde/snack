package com.example.snack.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.snack.ui.checkout.CheckoutScreen
import com.example.snack.ui.detail.SnackDetailScreen
import com.example.snack.ui.home.Home

@Composable
fun SnackNav(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            Home(
                onSnackClick = { snackId ->
                    navController.navigate("detail/$snackId")
                },
                onCheckoutClick = { navController.navigate("checkout") }
            )
        }
        composable(
            route = "detail/{snackId}",
            arguments = listOf(navArgument("snackId") { type = NavType.LongType })
        ) { backStackEntry ->
            val snackId = backStackEntry.arguments?.getLong("snackId") ?: return@composable
            SnackDetailScreen(
                snackId = snackId,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("checkout") {
            CheckoutScreen(
                onBackClick = { navController.popBackStack() },
                onConfirmOrder = {
                    // Aquí iría la lógica de procesar pago con el CartViewModel
                    // Por ahora simulamos éxito y volvemos al inicio limpiando el stack
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    }
}