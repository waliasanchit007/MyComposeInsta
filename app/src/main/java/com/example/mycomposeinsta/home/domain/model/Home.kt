package com.example.mycomposeinsta.home.domain.model

import com.example.mycomposeinsta.core.model.User

data class Post(
    val id: String,
    val image: String?,
    val user: User,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val commentsCount: Int,
    val timeStamp: Long
)

data class Story(
  val image: String,
  val name: String,
  val isSeen: Boolean = false
)

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch"
)