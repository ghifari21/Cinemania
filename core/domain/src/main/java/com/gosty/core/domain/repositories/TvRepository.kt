package com.gosty.core.domain.repositories

import androidx.paging.PagingData
import com.gosty.core.data.utils.Result
import com.gosty.core.domain.models.tv.TvDetailModel
import com.gosty.core.domain.models.tv.TvPreviewModel
import kotlinx.coroutines.flow.Flow

interface TvRepository {
    fun getTvAiringToday(): Flow<PagingData<TvPreviewModel>>
    fun getTvOnTheAir(): Flow<PagingData<TvPreviewModel>>
    fun getTvPopular(): Flow<PagingData<TvPreviewModel>>
    fun getTvTopRated(): Flow<PagingData<TvPreviewModel>>
    fun getTvDetail(id: Long): Flow<Result<TvDetailModel>>
}