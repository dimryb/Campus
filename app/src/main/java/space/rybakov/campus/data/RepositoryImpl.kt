package space.rybakov.campus.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import space.rybakov.campus.domain.Repository
import space.rybakov.campus.entities.Ad
import javax.inject.Inject

class RepositoryImpl  @Inject constructor() : Repository {
    private val _ads = MutableSharedFlow<List<Ad>>(replay = 1)
    override val ads: Flow<List<Ad>>
        get() = _ads

    override suspend fun getAds() {
        val adsList = mutableListOf(Ad(1, content = "тестовое объявление"))
        _ads.tryEmit(adsList)
    }
}