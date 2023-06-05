package space.rybakov.campus.presentation

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.rybakov.campus.domain.Repository
import space.rybakov.campus.entities.Ad
import space.rybakov.campus.entities.Review
import space.rybakov.campus.entities.ScheduleDate
import space.rybakov.campus.entities.Teacher
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    val ads: LiveData<List<Ad>> = repository.ads.asLiveData(Dispatchers.Default)
    val reviews: LiveData<List<Review>> = repository.reviews.asLiveData(Dispatchers.Default)
    val teachers: LiveData<List<Teacher>> = repository.teachers.asLiveData(Dispatchers.Default)

    val calendarVisible = MutableLiveData<Boolean>()
    val calendarDate = MutableLiveData<ScheduleDate>()
    val textDate = MutableLiveData<String>()

    fun getAds() {
        viewModelScope.launch {
            try {
                repository.getAds()
            } catch (e: Exception) {
                TODO("нужно сделать")
            }
        }
    }

    fun getLastReview() {
        viewModelScope.launch {
            try {
                repository.getLastReview()
            } catch (e: Exception) {
                TODO("нужно сделать")
            }
        }
    }

    fun getTeachersReview() {
        viewModelScope.launch {
            try {
                repository.getTeachers()
            } catch (e: Exception) {
                TODO("нужно сделать")
            }
        }
    }

    fun setDate(date: ScheduleDate){
        calendarDate.value = date
        textDate.value = date.toString()
    }

}