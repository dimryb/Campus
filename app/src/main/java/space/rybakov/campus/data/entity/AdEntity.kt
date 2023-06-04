package space.rybakov.campus.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import space.rybakov.campus.entities.Ad

@Entity
data class AdEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val content: String,
) {
    fun toDto(): Ad = Ad(id, title, content)
    companion object {
        fun fromDto(ad: Ad): AdEntity = with(ad){ return AdEntity(id, title, content) }
    }
}

fun List<AdEntity>.toDto(): List<Ad> = map(AdEntity::toDto)
fun List<Ad>.toEntity(): List<AdEntity> = map(AdEntity::fromDto)
