package com.gosty.core.data.api.services

import com.gosty.core.data.api.responses.general.GeneralResponse
import com.gosty.core.data.api.responses.tv.TvDetailResponse
import com.gosty.core.data.api.responses.tv.TvPreviewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvService {
    @GET("tv/airing_today")
    suspend fun getTvAiringToday(
        @Query("page") page: Int
    ): Response<GeneralResponse<TvPreviewResponse>>

    @GET("tv/on_the_air")
    suspend fun getTvOnTheAir(
        @Query("page") page: Int
    ): Response<GeneralResponse<TvPreviewResponse>>

    @GET("tv/popular")
    suspend fun getTvPopular(
        @Query("page") page: Int
    ): Response<GeneralResponse<TvPreviewResponse>>

    @GET("tv/top_rated")
    suspend fun getTvTopRated(
        @Query("page") page: Int
    ): Response<GeneralResponse<TvPreviewResponse>>

    @GET("tv/{id}")
    suspend fun getTvDetail(
        @Path("id") id: Long
    ): Response<TvDetailResponse>
}