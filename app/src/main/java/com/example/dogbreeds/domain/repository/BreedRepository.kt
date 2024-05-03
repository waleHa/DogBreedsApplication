package com.example.dogbreeds.domain.repository

import com.example.dogbreeds.data.network.DogBreedApi
import com.example.dogbreeds.domain.model.BreedImageModelResponse
import javax.inject.Inject

class BreedRepository @Inject constructor(private val dogBreedApi: DogBreedApi) {
    suspend fun getRandomImageForBreed(breedName:String): BreedImageModelResponse = dogBreedApi.getRandomImageForBreed(breedName)
}