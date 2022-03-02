package com.example.mycomposeinsta.reels.domain.model

import android.net.Uri
import com.example.mycomposeinsta.core.data.remote.model.galleryResponse.User

data class Reel(
    val id: Int,
    private val video: String,
    val user: User,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val commentsCount: Int
) {

  fun getVideoUrl(): Uri {
    return Uri.parse("asset:///${video}")
  }

}