package space.rybakov.campus.domain

import kotlinx.coroutines.flow.Flow
import space.rybakov.campus.entities.Ad
import space.rybakov.campus.entities.Review
import space.rybakov.campus.entities.Teacher

interface Repository {
    val ads: Flow<List<Ad>>
    val reviews: Flow<List<Review>>
    val teachers: Flow<List<Teacher>>

    suspend fun getAds()
    suspend fun getLastReview()
    suspend fun getTeachers()
}