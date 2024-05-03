package com.example.dogbreeds.ui.DogBreed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreeds.domain.model.BreedImageModelResponse
import com.example.dogbreeds.data.network.RetrofitInstance
import com.example.dogbreeds.domain.repository.BreedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedViewModel @Inject constructor(private val breedRepository: BreedRepository): ViewModel() {
//class DogBreedViewModel : ViewModel() {
    private val _breed: MutableLiveData<BreedImageModelResponse> = MutableLiveData()

    // Exposed as LiveData for observing changes from UI
    val breed: LiveData<BreedImageModelResponse> = _breed


    fun loadProducts(breedName: String) {
        viewModelScope.launch {
            try {
                val products = breedRepository.getRandomImageForBreed(breedName)
                _breed.postValue(products)
                // Process response
            } catch (e: Exception) {
                // Handle error
                Log.e("TAG: DogBreedViewModel", e.localizedMessage ?: "Error with default message")
            }
        }
    }
}
