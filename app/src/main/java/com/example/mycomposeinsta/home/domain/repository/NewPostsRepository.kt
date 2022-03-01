package com.example.mycomposeinsta.home.domain.repository

import com.example.mycomposeinsta.core.utils.Resource
import com.example.mycomposeinsta.home.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface NewPostsRepository {
    fun getPosts(): Flow<Resource<List<Post>>>
}