package com.example.dogbreeds.data.network

import com.example.dogbreeds.core.Constant
import com.example.dogbreeds.domain.model.BreedImageModelResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogBreedApi {
    @GET(Constant.DOG_BREEDS_ENDPOINT)
    suspend fun getRandomImageForBreed(@Path("breed") breed: String): BreedImageModelResponse
}