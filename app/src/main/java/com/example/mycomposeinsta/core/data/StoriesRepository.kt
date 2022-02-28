package com.example.mycomposeinsta.core.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.mycomposeinsta.core.model.Story
import com.example.mycomposeinsta.core.model.currentUser
import com.example.mycomposeinsta.core.model.names
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
object StoriesRepository {

  private val stories = mutableStateOf<List<Story>>(emptyList())

  private fun populateStories() {
    val _stories = ArrayList<Story>()

    _stories.add(
        Story(
            image = currentUser.image,
            name = "Your Story"
        )
    )

    (0..9).forEach { index ->
      val story = Story(
          image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg",
          name = names[index]
      )
      _stories.add(story)
    }

    stories.value = _stories
  }

  init {
    populateStories()
  }

  fun observeStories(): MutableState<List<Story>> = stories

}