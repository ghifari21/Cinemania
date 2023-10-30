package com.gosty.core.domain.di

import com.gosty.core.data.di.ApiModule
import com.gosty.core.data.di.FirebaseModule
import com.gosty.core.data.repositories.MovieRepositoryImpl
import com.gosty.core.data.repositories.TvRepositoryImpl
import com.gosty.core.domain.repositories.MovieRepository
import com.gosty.core.domain.repositories.TvRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ApiModule::class, FirebaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideMovieRepository(repository: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun provideTvRepository(repository: TvRepositoryImpl): TvRepository
}