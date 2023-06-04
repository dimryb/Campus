package space.rybakov.campus.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import space.rybakov.campus.entities.Review

@Entity
data class ReviewEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val content: String,
    val author: String,
    val teacher: String,
    val credit: Float,
) {
    fun toDto(): Review = Review(id, content, author, teacher, credit)

    companion object {
        fun fromDto(review: Review): ReviewEntity =
            with(review) { return ReviewEntity(id, content, author, teacher, credit) }
    }
}

fun List<ReviewEntity>.toDto(): List<Review> = map(ReviewEntity::toDto)
fun List<Review>.toEntity(): List<ReviewEntity> = map(ReviewEntity::fromDto)
