package com.example.mycomposeinsta.core.model.galleryResponse


import com.google.gson.annotations.SerializedName

data class Processing(
    @SerializedName("status")
    val status: String?
)