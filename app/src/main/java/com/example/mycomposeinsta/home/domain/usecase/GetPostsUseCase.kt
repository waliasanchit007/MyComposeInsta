package com.example.mycomposeinsta.home.domain.usecase

import com.example.mycomposeinsta.home.domain.repository.NewPostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: NewPostsRepository
) {
    operator fun invoke() = repository.getPostsByTag()
}