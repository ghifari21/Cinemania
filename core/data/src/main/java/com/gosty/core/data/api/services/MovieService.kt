package com.gosty.core.data.api.services

import com.gosty.core.data.api.responses.general.GeneralResponse
import com.gosty.core.data.api.responses.movie.MovieDetailResponse
import com.gosty.core.data.api.responses.movie.MoviePreviewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    suspend fun getMovieNowPlaying(
        @Query("page") page: Int
    ): Response<GeneralResponse<MoviePreviewResponse>>

    @GET("movie/popular")
    suspend fun getMoviePopular(
        @Query("page") page: Int
    ): Response<GeneralResponse<MoviePreviewResponse>>

    @GET("movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("page") page: Int
    ): Response<GeneralResponse<MoviePreviewResponse>>

    @GET("movie/upcoming")
    suspend fun getMovieUpcoming(
        @Query("page") page: Int
    ): Response<GeneralResponse<MoviePreviewResponse>>

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int,
        @Query("page") page: Int
    ): Response<MovieDetailResponse>
}