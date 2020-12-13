package com.example.swandroidhilt

import com.example.data.repositories.ApiCharacterRepositoryImp
import com.example.data.repositories.ApiMovieRepositoryImp
import com.example.domain.repositories.CharacterRepository
import com.example.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
class MainModule {
    @Provides
    fun provideCharacterRepository(): CharacterRepository {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCharacterRepositoryImp::class.java)
    }

    @Provides
    fun provideMovieRepository(): MovieRepository {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiMovieRepositoryImp::class.java)
    }
}