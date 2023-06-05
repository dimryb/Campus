package space.rybakov.campus.domain

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import space.rybakov.campus.entities.*

interface Repository {
    val ads: Flow<List<Ad>>
    val reviews: Flow<List<Review>>
    val teachers: Flow<List<Teacher>>

    suspend fun getAds()
    suspend fun getLastReview()
    suspend fun getTeachers()
    fun getSchedule(group: Group, date: ScheduleDate): List<Lesson>
    suspend fun fillSchedule()
}