package com.gosty.core.data.api

import androidx.paging.PagingSource
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.gosty.core.data.api.paging.MoviePagingSource
import com.gosty.core.data.api.responses.movie.MoviePreviewResponse
import com.gosty.core.data.api.services.MovieService
import com.gosty.core.data.utils.ServicePaging
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiDataSource @Inject constructor(
    private val movieService: MovieService,
    private val crashlytics: FirebaseCrashlytics
) {
    fun getMovieNowPlaying(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = ServicePaging.NOW_PLAYING
        )
    }

    fun getMoviePopular(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = ServicePaging.POPULAR
        )
    }

    fun getMovieTopRated(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = ServicePaging.TOP_RATED
        )
    }

    fun getMovieUpcoming(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = ServicePaging.UPCOMING
        )
    }
}