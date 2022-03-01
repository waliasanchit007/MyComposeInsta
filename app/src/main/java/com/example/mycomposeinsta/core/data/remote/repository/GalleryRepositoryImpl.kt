package com.example.mycomposeinsta.core.data.remote.repository

import android.util.Log
import com.example.mycomposeinsta.core.data.remote.GalleryApi
import com.example.mycomposeinsta.core.model.Gallery
import com.example.mycomposeinsta.core.model.toGallery
import com.example.mycomposeinsta.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(private val galleryApi: GalleryApi): GalleryRepository {

    override fun getGalleryPhotos(): Flow<Resource<Gallery>> = flow {
        try{
                emit(Resource.Loading())
                val response = galleryApi.getGallery()
                Log.d("sanchit", "getGalleryPhotos: $response")
                val gallery = response.toGallery()
                Log.d("sanchit", "getGalleryPhotos: $gallery")
                emit(Resource.Success(gallery))
        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}