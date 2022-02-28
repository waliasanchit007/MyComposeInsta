package com.example.mycomposeinsta.core.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.mycomposeinsta.core.model.Post
import com.example.mycomposeinsta.core.model.User
import com.example.mycomposeinsta.core.model.names
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext

@OptIn(ExperimentalCoroutinesApi::class)
object PostsRepository {

  private val posts = mutableStateOf<List<Post>>(emptyList())

  private fun populatePosts() {
    val _posts = ArrayList<Post>()
    (0..9).forEach { index ->
      val post = Post(
          id = index + 1,
          image = "https://source.unsplash.com/random/400x300?$index",
          user = User(
              name = names[index],
              username = names[index],
              image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg"
          ),
          likesCount = index + 100,
          commentsCount = index + 20,
          timeStamp = System.currentTimeMillis() - (index * 60000)
      )
      _posts.add(post)
    }

    posts.value = _posts
  }

  init {
    populatePosts()
  }

  fun observePosts(): MutableState<List<Post>> = posts

  suspend fun toggleLike(postId: Int) {
    updateLike(postId, true)
  }

  suspend fun performLike(postId: Int) {
    updateLike(postId, false)
  }

  private suspend fun updateLike(
    postId: Int,
    isToggle: Boolean
  ) {
    withContext(Dispatchers.IO) {
      val _posts = posts.value.toMutableList()
      for ((index, value) in _posts.withIndex()) {
        if (value.id == postId) {

          val isLiked = if (isToggle) !value.isLiked else true

          // check if isLiked is same as previous state
          if (isLiked != value.isLiked) {
            val likesCount = if (isLiked) value.likesCount.plus(1) else value.likesCount.minus(1)

            _posts[index] = value.copy(isLiked = isLiked, likesCount = likesCount)
          }

          break
        }
      }
      posts.value = _posts
    }
  }

}