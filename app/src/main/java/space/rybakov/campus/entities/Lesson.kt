package space.rybakov.campus.entities

data class Lesson(
    val id: Long = 0,
    val name: String,
    val groupId: Int,
    val dayInd: Int,
)
