package space.rybakov.campus.entities

data class Review(
    val content: String,
    val author: String = "",
    val teacher: String,
    val credit: Float,
)
