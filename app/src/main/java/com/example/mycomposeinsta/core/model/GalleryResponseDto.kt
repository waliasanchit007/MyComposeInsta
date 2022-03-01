package com.example.mycomposeinsta.core.model


import com.google.gson.annotations.SerializedName

data class GalleryResponseDto(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("success")
    val success: Boolean?
)

data class Gallery(
    val images :List<Image>?
)

fun GalleryResponseDto.toGallery() : Gallery {
   val images = data?.getOrNull(0)?.images
    return Gallery(
        images = images
    )
}

