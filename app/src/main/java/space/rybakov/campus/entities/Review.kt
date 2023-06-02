package space.rybakov.campus.entities

data class Review(
    val id: Int = 0,
    val content: String,
    val author: String = "",
    val teacher: String,
    val credit: Float,
)
