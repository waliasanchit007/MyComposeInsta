package com.example.mycomposeinsta.core.model


import com.google.gson.annotations.SerializedName

data class GalleryTagResponseDto(
    @SerializedName("data")
    val `data`: DataX?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("success")
    val success: Boolean?
)