package com.example.mycomposeinsta.core.di

import com.example.mycomposeinsta.core.data.remote.GalleryApi
import com.example.mycomposeinsta.core.data.remote.repository.GalleryRepository
import com.example.mycomposeinsta.core.data.remote.repository.GalleryRepositoryImpl
import com.example.mycomposeinsta.core.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGalleryApi(): GalleryApi {
        val client = OkHttpClient.Builder()
            .addInterceptor{
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Client-ID 56503c999bf1e12")
                    .build()
                it.proceed(request)
            }
            .build()
        return Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GalleryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: GalleryApi): GalleryRepository {
        return GalleryRepositoryImpl(api)
    }
}