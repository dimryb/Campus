package space.rybakov.campus.domain

import kotlinx.coroutines.flow.Flow
import space.rybakov.campus.entities.Ad

interface Repository {
    val ads: Flow<List<Ad>>

    suspend fun getAds()
}