package com.gosty.core.domain.usecases

import androidx.paging.PagingData
import com.gosty.core.data.utils.Result
import com.gosty.core.domain.models.movie.MovieDetailModel
import com.gosty.core.domain.models.movie.MoviePreviewModel
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getMovieNowPlaying(): Flow<PagingData<MoviePreviewModel>>
    fun getMoviePopular(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieTopRated(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieUpcoming(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieDetail(id: Long): Flow<Result<MovieDetailModel>>
}