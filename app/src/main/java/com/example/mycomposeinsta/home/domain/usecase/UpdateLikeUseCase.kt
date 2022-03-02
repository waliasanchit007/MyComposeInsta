package com.example.mycomposeinsta.home.domain.usecase

import com.example.mycomposeinsta.home.domain.model.Post
import javax.inject.Inject

class UpdateLikeUseCase {
    operator fun invoke( posts: List<Post>,
                         postId: String,
                         isToggle: Boolean): List<Post> {
        val _posts = posts.toMutableList()
        for ((index, value) in _posts.withIndex()) {
            if (value.id == postId) {

                val isLiked = if (isToggle) !value.isLiked else true

                // check if isLiked is same as previous state
                if (isLiked != value.isLiked) {
                    val likesCount =
                        if (isLiked) value.likesCount.plus(1) else value.likesCount.minus(1)

                    _posts[index] = value.copy(isLiked = isLiked, likesCount = likesCount)
                }
                break
            }
        }
        return _posts.toList()
    }
}