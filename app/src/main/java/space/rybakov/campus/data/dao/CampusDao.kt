package space.rybakov.campus.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import space.rybakov.campus.data.entity.AdEntity

@Dao
interface CampusDao {
    // Ads
    @Query("SELECT * FROM AdEntity ORDER BY id DESC")
    fun getAds(): Flow<List<AdEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAds(ad: AdEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAds(ads: List<AdEntity>)
}