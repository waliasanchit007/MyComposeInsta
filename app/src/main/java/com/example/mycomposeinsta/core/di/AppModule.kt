package com.example.mycomposeinsta.core.di

import com.example.mycomposeinsta.BuildConfig
import com.example.mycomposeinsta.core.data.remote.GalleryApi
import com.example.mycomposeinsta.core.data.remote.repository.GalleryRepository
import com.example.mycomposeinsta.core.data.remote.repository.GalleryRepositoryImpl
import com.example.mycomposeinsta.core.utils.Constants
import com.example.mycomposeinsta.home.domain.repository.NewPostsRepository
import com.example.mycomposeinsta.home.domain.repository.NewPostsRepositoryImplementation
import com.example.mycomposeinsta.home.domain.usecase.GetPostsUseCase
import com.example.mycomposeinsta.home.domain.usecase.UpdateLikeUseCase
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
                    .addHeader("Authorization", BuildConfig.IMGUR_CLIENT_ID)
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

    @Provides
    @Singleton
    fun providePostsRepository(api: GalleryApi): NewPostsRepository {
        return NewPostsRepositoryImplementation(api)
    }
    @Provides
    @Singleton
    fun provideGetPostsUseCase(repository: NewPostsRepository): GetPostsUseCase {
        return GetPostsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateLikesUseCase(): UpdateLikeUseCase {
        return UpdateLikeUseCase()
    }
}