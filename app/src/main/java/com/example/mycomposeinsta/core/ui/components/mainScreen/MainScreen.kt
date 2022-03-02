package com.example.mycomposeinsta.core.ui.components.mainScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.mycomposeinsta.core.model.galleryResponse.currentUser
import com.example.mycomposeinsta.core.navigation.HomeNavHost
import com.example.mycomposeinsta.core.navigation.HomeSection
import com.example.mycomposeinsta.core.ui.components.bottomBarHeight
import com.example.mycomposeinsta.core.ui.components.icon
import com.example.mycomposeinsta.core.utils.TestTags

@ExperimentalFoundationApi
@Composable
fun MainScreen () {

    val navController = rememberNavController()
    val navItems = HomeSection.values()
        .toList()
    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItems,
                currentSection = HomeSection.fromRoute(navController.currentBackStackEntryAsState().value?.destination?.route),
                onSectionSelected = {
                    navController.navigate(it.name)
                },
            )
        }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        HomeNavHost(navController = navController, modifier = modifier)
    }
}

@Composable
private fun BottomBar(
    items: List<HomeSection>,
    currentSection: HomeSection,
    onSectionSelected: (HomeSection) -> Unit,
) {
    BottomNavigation(
        modifier = Modifier.height(bottomBarHeight),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {

                    if (section == HomeSection.Profile) {
                        BottomBarProfile(selected)
                    } else {
                        Icon(
                            ImageBitmap.imageResource(id = iconRes),
                            modifier = Modifier.icon().testTag(section.tag),
                            contentDescription = ""
                        )
                    }

                },
                selected = selected,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun BottomBarProfile(isSelected: Boolean) {
    val shape = CircleShape

    val borderModifier = if (isSelected) {
        Modifier
            .border(
                color = Color.LightGray,
                width = 1.dp,
                shape = shape
            )
    } else Modifier

    val padding = if (isSelected) 3.dp else 0.dp

    Box(
        modifier = borderModifier
    ) {
        Box(
            modifier = Modifier
                .icon()
                .padding(padding)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape)
                .testTag(TestTags.PROFILE_SECTION)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = currentUser.image,
                ),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }

}


