package com.example.mycomposeinsta.core.data.remote.model.galleryResponse


import com.google.gson.annotations.SerializedName

data class DescriptionAnnotations(
    @SerializedName("hashtag")
    val hashtag: List<Hashtag>?
)