package com.gosty.core.domain.di

import com.gosty.core.domain.interactors.MovieInteractor
import com.gosty.core.domain.interactors.TvInteractor
import com.gosty.core.domain.usecases.MovieUseCase
import com.gosty.core.domain.usecases.TvUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun provideMovieUseCase(interactor: MovieInteractor): MovieUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideTvUseCase(interactor: TvInteractor): TvUseCase
}