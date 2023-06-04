package space.rybakov.campus.entities

data class Ad(
    val id: Long,
    val title: String = "Заголовок",
    val content: String,
)