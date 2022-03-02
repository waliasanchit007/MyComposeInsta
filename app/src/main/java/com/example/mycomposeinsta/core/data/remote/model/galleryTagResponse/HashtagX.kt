package com.example.mycomposeinsta.core.data.remote.model.galleryTagResponse


import com.google.gson.annotations.SerializedName

data class HashtagX(
    @SerializedName("indices")
    val indices: List<Int>?,
    @SerializedName("tag")
    val tag: String?
)