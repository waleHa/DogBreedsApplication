package com.example.dogbreeds.domain.model


import com.google.gson.annotations.SerializedName

data class BreedImageModelResponse(
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("status")
    val status: String? = ""
)