package com.example.mycomposeinsta.core.navigation

import com.example.mycomposeinsta.R

enum class HomeSection(
    val icon: Int,
    val selectedIcon: Int
) {
    Home(R.drawable.ic_outlined_home, R.drawable.ic_filled_home),
    Reels(R.drawable.ic_outlined_reels, R.drawable.ic_filled_reels),
    Add(R.drawable.ic_outlined_add, R.drawable.ic_outlined_add),
    Favorite(R.drawable.ic_outlined_favorite, R.drawable.ic_filled_favorite),
    Profile(R.drawable.ic_outlined_reels, R.drawable.ic_outlined_reels);

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
