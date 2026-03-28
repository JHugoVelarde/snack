package com.example.snack.ui.search

data class SearchCategory(
    val id: Long,
    val name: String,
    val imageUrl: String
)

object FakeSearchData {
    val categories = listOf(
        SearchCategory(1L, "Postres", "https://picsum.photos/id/106/200"),
        SearchCategory(2L, "Salados", "https://picsum.photos/id/107/200"),
        SearchCategory(3L, "Bebidas", "https://picsum.photos/id/108/200"),
        SearchCategory(4L, "Vegano", "https://picsum.photos/id/109/200"),
        SearchCategory(5L, "Sin Gluten", "https://picsum.photos/id/110/200"),
        SearchCategory(6L, "Ofertas", "https://picsum.photos/id/111/200")
    )
}
