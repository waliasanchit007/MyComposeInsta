package com.example.mycomposeinsta.reels.domain.repository

import com.example.mycomposeinsta.reels.domain.model.Reel
import com.example.mycomposeinsta.core.model.galleryResponse.User
import com.example.mycomposeinsta.home.domain.model.names
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
object ReelsRepository {

  private val reels = arrayListOf<Reel>()

  private fun populateReels() {
    val _reels = ArrayList<Reel>()
    (0..9).forEach { index ->
      val post = Reel(
          id = index + 1,
          video = videos[index],
          user = User(
              name = names[index],
              username = names[index],
              image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg"
          ),
          likesCount = index + 100,
          commentsCount = index + 20
      )
      _reels.add(post)
    }

    reels.clear()
    reels.addAll(_reels)
  }

  init {
    populateReels()
  }

  fun getReels(): List<Reel> = reels
}

private val videos = listOf(
    "food.mp4",
    "soap-bubbles.mp4",
    "castle.mp4",
    "lake.mp4",
    "icecream.mp4",
    "soap-bubbles.mp4",
    "castle.mp4",
    "lake.mp4",
    "icecream.mp4",
    "soap-bubbles.mp4",
    "castle.mp4",
    "lake.mp4",
    "icecream.mp4",
)