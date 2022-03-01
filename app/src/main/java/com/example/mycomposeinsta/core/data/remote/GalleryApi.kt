package com.example.mycomposeinsta.core.data.remote

import com.example.mycomposeinsta.core.model.GalleryResponseDto
import retrofit2.http.GET

interface GalleryApi {

    @GET("gallery/hot?showViral=true&mature=true&album_previews=true")
    suspend fun getGallery():GalleryResponseDto
}