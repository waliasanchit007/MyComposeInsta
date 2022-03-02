package com.example.mycomposeinsta.core.data.remote.model.galleryResponse


import com.example.mycomposeinsta.core.data.remote.model.galleryTagResponse.DataX
import com.google.gson.annotations.SerializedName

data class GalleryTagResponseDto(
    @SerializedName("data")
    val `data`: DataX?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("success")
    val success: Boolean?
)