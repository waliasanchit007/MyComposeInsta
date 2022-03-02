package com.example.mycomposeinsta

import android.util.Log
import com.example.mycomposeinsta.core.data.remote.GalleryApi
import com.example.mycomposeinsta.core.utils.Constants
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiTest {
    private val client = OkHttpClient.Builder()
        .addInterceptor{
            val request = it.request().newBuilder()
                .addHeader("Authorization",BuildConfig.IMGUR_CLIENT_ID)
                .build()
            it.proceed(request)
        }
        .build()
    private val retrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(GalleryApi::class.java)

    @Test
    fun getGalleryWorking(){
        runBlocking {

            val response = retrofit.getGallery()
            Log.d("sanchit", "getGalleryWorking: $response")
        }
    }
}