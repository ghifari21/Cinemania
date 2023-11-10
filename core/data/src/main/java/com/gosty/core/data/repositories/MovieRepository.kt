package com.gosty.core.data.repositories

import androidx.paging.PagingData
import com.gosty.common.utils.Result
import com.gosty.model.movie.MovieDetailModel
import com.gosty.model.movie.MoviePreviewModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovieNowPlaying(): Flow<PagingData<MoviePreviewModel>>
    fun getMoviePopular(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieTopRated(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieUpcoming(): Flow<PagingData<MoviePreviewModel>>
    fun getMovieDetail(id: Long): Flow<Result<MovieDetailModel>>
    fun getMovieNowPlayingHighlight(): Flow<Result<List<MoviePreviewModel>>>
    fun getMoviePopularHighlight(): Flow<Result<List<MoviePreviewModel>>>
    fun getMovieTopRatedHighlight(): Flow<Result<List<MoviePreviewModel>>>
    fun getMovieUpcomingHighlight(): Flow<Result<List<MoviePreviewModel>>>
}