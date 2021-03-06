package com.example.mycomposeinsta.home.ui

import com.example.mycomposeinsta.home.domain.model.Post

data class PostsUiState (
    val isLoading:Boolean = false,
    var posts:List<Post> = emptyList(),
    val error:String = ""
)