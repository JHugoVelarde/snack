package com.example.snack.data

data class SnackCollection(
    val id: Long,
    val name: String,
    val snacks: List<Snack>
)

object FakeSnackData {
    val featuredSnacks = listOf(
        Snack(1L, "Cupcake", "https://picsum.photos/id/102/300", 299, "A tag line"),
        Snack(2L, "Donut", "https://picsum.photos/id/103/300", 199, "A tag line"),
        Snack(3L, "Macarons", "https://picsum.photos/id/104/300", 599, "A tag line")
    )

    val popularSnacks = listOf(
        Snack(4L, "Chips", "https://picsum.photos/id/106/200", 299),
        Snack(5L, "Pretzels", "https://picsum.photos/id/107/200", 199),
        Snack(6L, "Smoothies", "https://picsum.photos/id/108/200", 599),
        Snack(7L, "Chips", "https://picsum.photos/id/106/200", 299),
        Snack(8L, "Pretzels", "https://picsum.photos/id/107/200", 199),
        Snack(9L, "Smoothies", "https://picsum.photos/id/108/200", 599)
    )

    val snacks = listOf(
        Snack(1L, "Cupcake de Vainilla", "https://picsum.photos/id/102/200", 299, "Clásico"),
        Snack(2L, "Donut Glaseado", "https://picsum.photos/id/103/200", 199, "Recién horneado"),
        Snack(3L, "Macarons Franceses", "https://picsum.photos/id/104/200", 599, "Especialidad")
    )

    val collections = listOf(
        SnackCollection(1L, "Populares", snacks),
        SnackCollection(2L, "Recién Horneados", snacks.reversed()),
        SnackCollection(3L, "Para Compartir", snacks.shuffled())
    )
}
