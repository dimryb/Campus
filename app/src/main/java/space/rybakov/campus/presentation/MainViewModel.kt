package space.rybakov.campus.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import space.rybakov.campus.domain.Repository
import space.rybakov.campus.entities.Ad
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    val data: LiveData<List<Ad>> = repository.ads.asLiveData(Dispatchers.Default)
}