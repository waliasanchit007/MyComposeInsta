package com.example.mycomposeinsta.core.data.remote.repository

import com.example.mycomposeinsta.core.model.Gallery
import com.example.mycomposeinsta.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
   fun getGalleryPhotos() : Flow<Resource<Gallery>>
}