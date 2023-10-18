package com.gosty.core.domain.repositories

import androidx.paging.PagingData
import com.gosty.core.domain.models.movie.MoviePreviewModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovieNowPlaying(): Flow<PagingData<MoviePreviewModel>>
    fun getMoviePopular(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieTopRated(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieUpcoming(): Flow<PagingData<MoviePreviewModel>>
}