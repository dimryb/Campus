package space.rybakov.campus.entities

data class Ad(
    val id: Int,
    val title: String = "Заголовок",
    val content: String,
)