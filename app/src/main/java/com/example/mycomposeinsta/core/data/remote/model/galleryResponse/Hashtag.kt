package com.example.mycomposeinsta.core.data.remote.model.galleryResponse


import com.google.gson.annotations.SerializedName

data class Hashtag(
    @SerializedName("indices")
    val indices: List<Int>?,
    @SerializedName("tag")
    val tag: String?
)