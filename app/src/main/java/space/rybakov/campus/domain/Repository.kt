package space.rybakov.campus.domain

import kotlinx.coroutines.flow.Flow
import space.rybakov.campus.entities.Ad
import space.rybakov.campus.entities.Review

interface Repository {
    val ads: Flow<List<Ad>>
    val review: Flow<List<Review>>

    suspend fun getAds()
    suspend fun getLastReview()
}