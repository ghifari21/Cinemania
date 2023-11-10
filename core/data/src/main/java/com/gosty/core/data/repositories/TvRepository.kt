package com.gosty.core.data.repositories

import androidx.paging.PagingData
import com.gosty.common.utils.Result
import com.gosty.model.tv.TvDetailModel
import com.gosty.model.tv.TvPreviewModel
import kotlinx.coroutines.flow.Flow

interface TvRepository {
    fun getTvAiringToday(): Flow<PagingData<TvPreviewModel>>
    fun getTvOnTheAir(): Flow<PagingData<TvPreviewModel>>
    fun getTvPopular(): Flow<PagingData<TvPreviewModel>>
    fun getTvTopRated(): Flow<PagingData<TvPreviewModel>>
    fun getTvDetail(id: Long): Flow<Result<TvDetailModel>>
    fun getTvAiringTodayHighlight(): Flow<Result<List<TvPreviewModel>>>
    fun getTvOnTheAirHighlight(): Flow<Result<List<TvPreviewModel>>>
    fun getTvPopularHighlight(): Flow<Result<List<TvPreviewModel>>>
    fun getTvTopRatedHighlight(): Flow<Result<List<TvPreviewModel>>>
}