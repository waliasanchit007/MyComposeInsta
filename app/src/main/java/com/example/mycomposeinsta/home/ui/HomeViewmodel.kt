package com.example.mycomposeinsta.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeinsta.core.utils.Resource
import com.example.mycomposeinsta.home.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(val useCase: GetPostsUseCase): ViewModel() {
    init {
        getPosts()
    }

    private fun getPosts() {
        useCase.invoke().onEach{ result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("sanchit", "getCoin: on success result= ${result.data}")
                }
                is Resource.Error -> {
                    Log.d("sanchit", "getCoin: on error result= ${result.message}")

                }
                is Resource.Loading -> {
                    Log.d("sanchit", "getCoin: on loading")
                }
            }
        }.launchIn(viewModelScope)
    }
}