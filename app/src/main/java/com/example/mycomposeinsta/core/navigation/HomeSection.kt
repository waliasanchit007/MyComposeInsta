package com.example.mycomposeinsta.core.navigation

import com.example.mycomposeinsta.R
import com.example.mycomposeinsta.core.utils.TestTags

enum class HomeSection(
    val icon: Int,
    val selectedIcon: Int,
    val tag:String
) {
    Home(R.drawable.ic_outlined_home, R.drawable.ic_filled_home,TestTags.HOME_SECTION),
    Reels(R.drawable.ic_outlined_reels, R.drawable.ic_filled_reels, TestTags.REELS_SECTION),
    Add(R.drawable.ic_outlined_add, R.drawable.ic_outlined_add,TestTags.ADD_SECTION),
    Favorite(R.drawable.ic_outlined_favorite, R.drawable.ic_filled_favorite,TestTags.FAVOURITE_SECTION),
    Profile(R.drawable.ic_outlined_reels, R.drawable.ic_outlined_reels,TestTags.PROFILE_SECTION);

    companion object {
        fun fromRoute(route: String?): HomeSection =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                Reels.name -> Reels
                Add.name -> Add
                Favorite.name -> Favorite
                Profile.name -> Profile
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}
