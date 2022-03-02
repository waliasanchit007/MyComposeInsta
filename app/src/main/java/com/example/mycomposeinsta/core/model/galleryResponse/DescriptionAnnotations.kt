package com.example.mycomposeinsta.core.model.galleryResponse


import com.google.gson.annotations.SerializedName

data class DescriptionAnnotations(
    @SerializedName("hashtag")
    val hashtag: List<Hashtag>?
)