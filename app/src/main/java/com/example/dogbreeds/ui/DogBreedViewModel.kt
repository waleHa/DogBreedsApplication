package com.example.dogbreeds.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreeds.domain.BreedImageModelResponse
import com.example.dogbreeds.network.RetrofitInstance
import kotlinx.coroutines.launch

//@HiltViewModel
//class DogBreedViewModel @Inject constructor(private val breedRepository: BreedRepository): ViewModel() {
class DogBreedViewModel : ViewModel() {
    private val _breed: MutableLiveData<BreedImageModelResponse> = MutableLiveData()

    // Exposed as LiveData for observing changes from UI
    val breed: LiveData<BreedImageModelResponse> = _breed

    init {

        viewModelScope.launch {
            try {
                val response =
                    _breed.postValue(RetrofitInstance.apiClient.getRandomImageForBreed("affenpinscher"))
                // Process response
            } catch (e: Exception) {
                // Handle error
                Log.e("TAG: DogBreedViewModel", e.localizedMessage ?: "Error with default message")
            }
        }
    }

    fun loadProducts(breedName: String) {
        viewModelScope.launch {
            val products = RetrofitInstance.apiClient.getRandomImageForBreed(breedName)
            _breed.postValue(products)
        }
    }
}
