package com.example.dogbreeds.network

import com.example.dogbreeds.core.Constant
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//@InstallIn(SingletonComponent::class)
//@Module
object RetrofitInstance {
//    @Singleton
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

//    @Singleton
    private val converter = GsonConverterFactory.create()

//    @Reusable
//    @Singleton
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

//    @Singleton
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converter)
        .build()

//    @Singleton
    val apiClient = retrofit.create(DogBreedApi::class.java)
}