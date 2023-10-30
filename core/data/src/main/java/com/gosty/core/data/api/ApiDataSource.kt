package com.gosty.core.data.api

import androidx.paging.PagingSource
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.gosty.core.data.api.paging.MoviePagingSource
import com.gosty.core.data.api.paging.TvPagingSource
import com.gosty.core.data.api.responses.movie.MovieDetailResponse
import com.gosty.core.data.api.responses.movie.MoviePreviewResponse
import com.gosty.core.data.api.responses.tv.TvDetailResponse
import com.gosty.core.data.api.responses.tv.TvPreviewResponse
import com.gosty.core.data.api.services.MovieService
import com.gosty.core.data.api.services.TvService
import com.gosty.core.data.utils.MovieServicePaging
import com.gosty.core.data.utils.Result
import com.gosty.core.data.utils.TvServicePaging
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiDataSource @Inject constructor(
    private val movieService: MovieService,
    private val tvService: TvService,
    private val crashlytics: FirebaseCrashlytics
) {
    // Movies
    fun getMovieNowPlaying(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.NOW_PLAYING
        )
    }

    fun getMoviePopular(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.POPULAR
        )
    }

    fun getMovieTopRated(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.TOP_RATED
        )
    }

    fun getMovieUpcoming(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.UPCOMING
        )
    }

    fun getMovieDetail(id: Long): Flow<Result<MovieDetailResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = movieService.getMovieDetail(id)
            if (response.isSuccessful) {
                emit(Result.Success(response.body()!!))
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message))
        }
    }

    // Tvs
    fun getTvAiringToday(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.AIRING_TODAY
        )
    }

    fun getTvOnTheAir(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.ON_THE_AIR
        )
    }

    fun getTvPopular(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.POPULAR
        )
    }

    fun getTvTopRated(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.TOP_RATED
        )
    }

    fun getTvDetail(id: Long): Flow<Result<TvDetailResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = tvService.getTvDetail(id)
            if (response.isSuccessful) {
                emit(Result.Success(response.body()!!))
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message))
        }
    }
}