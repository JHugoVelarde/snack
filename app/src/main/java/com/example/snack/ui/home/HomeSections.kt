package com.example.snack.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeSections(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    FEED("Inicio", Icons.Outlined.Home, "home/feed"),
    SEARCH("Buscar", Icons.Outlined.Search, "home/search"),
    CART("Carrito", Icons.Outlined.ShoppingCart, "home/cart"),
    PROFILE("Perfil", Icons.Outlined.Person, "home/profile")
}