package com.example.mycomposeinsta.home.domain.repository

import com.example.mycomposeinsta.core.data.remote.GalleryApi
import com.example.mycomposeinsta.core.model.toPost
import com.example.mycomposeinsta.core.utils.Resource
import com.example.mycomposeinsta.home.domain.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class NewPostsRepositoryImplementation @Inject constructor(private val api: GalleryApi) :
    NewPostsRepository {
    override fun getPosts(): Flow<Resource<List<Post>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getGallery()
            val posts = response.data?.map { it.toPost() }
            posts?.let {
                emit(Resource.Success(posts))
            } ?: emit(Resource.Error("Unknown Error"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}