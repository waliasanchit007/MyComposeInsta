package com.example.mycomposeinsta.home.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycomposeinsta.MainActivity
import com.example.mycomposeinsta.core.navigation.HomeSection
import com.example.mycomposeinsta.core.ui.components.mainScreen.MainScreen
import com.example.mycomposeinsta.core.utils.TestTags
import com.example.mycomposeinsta.core.ui.theme.MyComposeInstaTheme

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @OptIn(ExperimentalFoundationApi::class)
    @Before
    fun setUp() {
        composeRule.setContent {
            val navController = rememberNavController()
            MyComposeInstaTheme {
                NavHost(
                    navController = navController,
                    startDestination = HomeSection.Home.name
                ){
                    composable(route = HomeSection.Home.name){
                        MainScreen()
                    }
                }
            }
        }
    }

    @Test
    fun clickReels_goToReels(){
        composeRule.onNodeWithText("Reels", useUnmergedTree = true).assertDoesNotExist()
        composeRule.onNodeWithTag(TestTags.REELS_SECTION,useUnmergedTree = true).performClick()
        composeRule.onNodeWithText("Reels", useUnmergedTree = true).assertExists()
    }
}