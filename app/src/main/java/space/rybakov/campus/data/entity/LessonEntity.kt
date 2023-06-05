package space.rybakov.campus.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import space.rybakov.campus.entities.Lesson

@Entity
data class LessonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
) {
    fun toDto(): Lesson = Lesson(id, name)

    companion object {
        fun fromDto(ad: Lesson): LessonEntity = with(ad) { return LessonEntity(id, name) }
    }
}

fun List<LessonEntity>.toDto(): List<Lesson> = map(LessonEntity::toDto)
fun List<Lesson>.toEntity(): List<LessonEntity> = map(LessonEntity::fromDto)
