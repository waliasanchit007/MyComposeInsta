package com.example.mycomposeinsta.core.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycomposeinsta.home.ui.components.Home
import com.example.mycomposeinsta.reels.components.Reels

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = HomeSection.Home.name
    ) {
        composable(route = HomeSection.Home.name) {
            Home()
        }
        composable(route = HomeSection.Reels.name) {
            Reels()
        }
        composable(route = HomeSection.Add.name) {
            Content(title = "Add Post options")
        }
        composable(route = HomeSection.Favorite.name) {
            Content(title = "Favorite")
        }
        composable(route = HomeSection.Profile.name) {
            Content(title = "Profile")
        }
    }
}

@Composable
fun Content(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
    }
}