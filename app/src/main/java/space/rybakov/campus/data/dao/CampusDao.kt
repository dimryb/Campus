package space.rybakov.campus.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import space.rybakov.campus.data.entity.AdEntity
import space.rybakov.campus.data.entity.LessonEntity
import space.rybakov.campus.data.entity.ReviewEntity
import space.rybakov.campus.data.entity.TeacherEntity
import space.rybakov.campus.entities.Group
import space.rybakov.campus.entities.ScheduleDate

@Dao
interface CampusDao {
    // Ads
    @Query("SELECT * FROM AdEntity ORDER BY id DESC")
    fun getAds(): Flow<List<AdEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAds(ad: AdEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAds(ads: List<AdEntity>)

    @Query("SELECT * FROM ReviewEntity ORDER BY id DESC")
    fun getReviews(): Flow<List<ReviewEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviews(review: ReviewEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviews(reviews: List<ReviewEntity>)

    @Query("SELECT * FROM TeacherEntity ORDER BY id DESC")
    fun getTeacher(): Flow<List<TeacherEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacher: TeacherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacher: List<TeacherEntity>)

    @Query("SELECT * FROM LessonEntity WHERE groupId = :groupId AND dayInd = :dayInd ORDER BY id DESC")
    fun getSchedule(groupId: Int, dayInd: Int): List<LessonEntity>
    //fun getSchedule(groupId: Int): List<LessonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(lesson: LessonEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(lessons: List<LessonEntity>)
}