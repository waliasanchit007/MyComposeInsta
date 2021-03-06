package com.example.mycomposeinsta.home.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mycomposeinsta.R
import com.example.mycomposeinsta.core.ui.components.icon
import com.example.mycomposeinsta.home.domain.repository.PostsRepository
import com.example.mycomposeinsta.home.domain.repository.StoriesRepository
import com.example.mycomposeinsta.home.domain.model.Post
import com.example.mycomposeinsta.home.domain.model.Story
import com.example.mycomposeinsta.home.ui.HomeViewmodel
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun Home(
    viewmodel: HomeViewmodel = hiltViewModel()
) {

    val coroutineScope = rememberCoroutineScope()
    val postsUiState by viewmodel.postState

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Scaffold(
            Modifier.fillMaxSize(),
            topBar = { Toolbar() }) {
            val posts = postsUiState.posts
            val stories by StoriesRepository.observeStories()
            LazyColumn{
                item {
                    StoriesSection(stories)
                    Divider()
                }
                itemsIndexed(posts){ _, post ->
                    Post(post,
                        onDoubleClick = {
                            coroutineScope.launch {
                                viewmodel.performLike(post.id)
                            }
                        },
                        onLikeToggle = {
                            coroutineScope.launch {
                                viewmodel.toggleLike(post.id)
                            }
                        }
                    )
                }

            }

        }
        if(postsUiState.error.isNotBlank()) {
            Text(
                text = postsUiState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            )
        }
        if(postsUiState.isLoading) {
            CircularProgressIndicator()
        }
    }

}

@Composable
private fun Toolbar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                ImageBitmap.imageResource(id = R.drawable.ic_outlined_camera),
                modifier = Modifier.icon(),
                contentDescription = ""
            )
            Box(
                modifier = Modifier.padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_instagram),
                    contentDescription = ""
                )
            }
            Icon(
                ImageBitmap.imageResource(id = R.drawable.ic_dm),
                modifier = Modifier.icon(),
                contentDescription = ""
            )
        }
    }
}

@Composable
private fun StoriesSection(stories: List<Story>) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Stories", style = MaterialTheme.typography.subtitle2)
            Text(text = "Watch All", style = MaterialTheme.typography.subtitle2)
        }
        StoriesList(stories)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun StoriesList(stories: List<Story>) {
    LazyRow {
        itemsIndexed(stories){ _, story ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
            ) {
                StoryImage(imageUrl = story.image)
                Spacer(modifier = Modifier.height(5.dp))
                Text(story.name, style = MaterialTheme.typography.caption)
            }

        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun Post(
    post: Post,
    onDoubleClick: (Post) -> Unit,
    onLikeToggle: (Post) -> Unit
) {
    PostView(post, onDoubleClick, onLikeToggle)
}