package space.rybakov.campus.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.rybakov.campus.domain.Repository
import space.rybakov.campus.entities.Ad
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    val ads: LiveData<List<Ad>> = repository.ads.asLiveData(Dispatchers.Default)

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

}