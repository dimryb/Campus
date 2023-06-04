package space.rybakov.campus.entities

data class Review(
    val id: Int,
    val content: String,
    val author: String = "",
    val teacher: String,
    val credit: Float,
)
