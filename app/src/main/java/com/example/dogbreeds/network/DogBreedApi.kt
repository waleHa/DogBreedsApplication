package com.example.dogbreeds.network

import com.example.dogbreeds.core.Constant
import com.example.dogbreeds.domain.BreedImageModelResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogBreedApi {
    //    @GET(Constant.DOG_BREEDS_ENDPOINT)
    @GET("breed/{breed}/image/random")

    fun getRandomImageForBreed(@Path("breed") breed: String): BreedImageModelResponse
}