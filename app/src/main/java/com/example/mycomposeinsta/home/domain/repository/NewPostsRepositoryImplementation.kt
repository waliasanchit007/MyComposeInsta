package com.example.mycomposeinsta.home.domain.repository

import com.example.mycomposeinsta.core.data.remote.GalleryApi
import com.example.mycomposeinsta.core.model.galleryResponse.User
import com.example.mycomposeinsta.core.model.galleryResponse.toPost
import com.example.mycomposeinsta.core.utils.Resource
import com.example.mycomposeinsta.home.domain.model.Post
import com.example.mycomposeinsta.home.domain.model.names
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject
import kotlin.random.Random

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

    override fun getPostsByTag(): Flow<Resource<List<Post>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getGalleryTagResponse()
            val posts = response.data?.items?.filter {
                if(it.images==null) return@filter false
               else if(it.images.isNotEmpty()){
                    if (!it.images[0].link.isNullOrEmpty())
                        if(it.images[0].type?.contains("image") == true)
                            return@filter true
                }
                return@filter false
            }?.map {
                val random = Random.nextInt(0,9)
                Post(
                    it.id?:"slkjf",
                    image = it.images!![0].link,
                    user = User(
                        name = names[random],
                        username = names[random],
                        image = "https://randomuser.me/api/portraits/men/${random+1}.jpg"
                    ),
                    likesCount = it.ups?:8,
                    commentsCount = it.commentCount?:3,
                    timeStamp = (it.datetime?:System.currentTimeMillis() - (3 * 60000))
                )
            }
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