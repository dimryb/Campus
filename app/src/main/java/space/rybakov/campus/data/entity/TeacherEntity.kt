package space.rybakov.campus.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import space.rybakov.campus.entities.Teacher

@Entity
data class TeacherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val teacherName: String,
    val rating: Float,
) {
    fun toDto(): Teacher = Teacher(id, teacherName, rating)

    companion object {
        fun fromDto(teacher: Teacher): TeacherEntity =
            with(teacher) { return TeacherEntity(id, name, rating) }
    }
}

fun List<TeacherEntity>.toDto(): List<Teacher> = map(TeacherEntity::toDto)
fun List<Teacher>.toEntity(): List<TeacherEntity> = map(TeacherEntity::fromDto)
