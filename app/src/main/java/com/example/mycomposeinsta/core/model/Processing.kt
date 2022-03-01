package com.example.mycomposeinsta.core.model


import com.google.gson.annotations.SerializedName

data class Processing(
    @SerializedName("status")
    val status: String?
)