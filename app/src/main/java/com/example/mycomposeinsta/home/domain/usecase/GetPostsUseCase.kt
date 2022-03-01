package com.example.mycomposeinsta.home.domain.usecase

import com.example.mycomposeinsta.home.domain.repository.NewPostsRepository

class GetPostsUseCase constructor(
    private val repository: NewPostsRepository
) {
    operator fun invoke() = repository.getPosts()
}