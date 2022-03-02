package com.example.mycomposeinsta.home.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeinsta.core.utils.Resource
import com.example.mycomposeinsta.home.domain.usecase.GetPostsUseCase
import com.example.mycomposeinsta.home.domain.usecase.UpdateLikeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val updateLikeUseCase: UpdateLikeUseCase,
) : ViewModel() {

    private var _postState = mutableStateOf(PostsUiState())
    val postState: State<PostsUiState> = _postState

    init {
        getPosts()
    }

    private fun getPosts() {
        getPostsUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val posts = result.data
                    if (posts != null)
                        _postState.value =
                            _postState.value.copy(isLoading = false, posts = posts, error = "")
                }
                is Resource.Error -> {
                    _postState.value =
                        _postState.value.copy(isLoading = false, error = result.message!!)
                }
                is Resource.Loading -> {
                    _postState.value = _postState.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun toggleLike(postId: String) {
        _postState.value =
            _postState.value.copy(posts = updateLikeUseCase(_postState.value.posts, postId, true))
    }

    fun performLike(postId: String) {
        _postState.value =
            _postState.value.copy(posts = updateLikeUseCase(_postState.value.posts, postId, false))
    }
}