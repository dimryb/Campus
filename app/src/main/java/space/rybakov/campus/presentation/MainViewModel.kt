package space.rybakov.campus.presentation

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.rybakov.campus.domain.Repository
import space.rybakov.campus.entities.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    val ads: LiveData<List<Ad>> = repository.ads.asLiveData(Dispatchers.Default)
    val reviews: LiveData<List<Review>> = repository.reviews.asLiveData(Dispatchers.Default)
    val teachers: LiveData<List<Teacher>> = repository.teachers.asLiveData(Dispatchers.Default)
    val schedule = MutableLiveData<List<Lesson>>()

    val calendarVisible = MutableLiveData<Boolean>()
    val schedulerVisible = MutableLiveData<Boolean>()
    val calendarDate = MutableLiveData<ScheduleDate>()
    val textDate = MutableLiveData<String>()
    val group = MutableLiveData<Group>()
    val reviewEnable = MutableLiveData(false)

    fun getAds() {
        viewModelScope.launch {
            try {
                repository.getAds()
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }
    }

    fun getLastReview() {
        viewModelScope.launch {
            try {
                repository.getLastReview()
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }
    }

    fun getTeachersReview() {
        viewModelScope.launch {
            try {
                repository.getTeachers()
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }
    }

    fun setDate(date: ScheduleDate) {
        calendarDate.value = date
        textDate.value = date.toString()

        getSchedule()
    }

    fun setGroup(g: Group) {
        group.value = g

        getSchedule()
    }

    fun getSchedule() {
        viewModelScope.launch {
            try {
                repository.fillSchedule() // Заполняет тестовыми данными
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }
        try {
            val date: ScheduleDate = calendarDate.value ?: ScheduleDate.now()
            val group: Group = group.value ?: Group(0, "")
            schedule.value = repository.getSchedule(group, date)
        } catch (e: Exception) {
            Log.e("error", e.toString())
        }
    }
}