package com.example.mycomposeinsta.home.ui.components

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeinsta.core.data.remote.repository.GalleryRepository
import com.example.mycomposeinsta.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(val galleryRepository: GalleryRepository): ViewModel() {
    init {
        getGallery()
    }

    private fun getGallery() {
        galleryRepository.getGalleryPhotos().onEach{ result ->
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