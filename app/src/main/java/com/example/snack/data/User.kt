package com.example.snack.data

data class User(
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String,
    val address: String
)

object FakeUserData {
    val currentUser = User(
        id = "user_123",
        name = "Ana García",
        email = "ana.garcia@example.com",
        avatarUrl = "https://picsum.photos/id/64/200/200",
        address = "Av. Siempre Viva 742, Springfield"
    )
}
