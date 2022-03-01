package com.example.mycomposeinsta.core.model


import com.google.gson.annotations.SerializedName

data class Hashtag(
    @SerializedName("indices")
    val indices: List<Int>?,
    @SerializedName("tag")
    val tag: String?
)