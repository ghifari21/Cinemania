package com.gosty.core.domain.interactors

import androidx.paging.PagingData
import com.gosty.core.data.utils.Result
import com.gosty.core.domain.models.tv.TvDetailModel
import com.gosty.core.domain.models.tv.TvPreviewModel
import com.gosty.core.domain.repositories.TvRepository
import com.gosty.core.domain.usecases.TvUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvInteractor @Inject constructor(
    private val tvRepository: TvRepository
) : TvUseCase {
    override fun getTvAiringToday(): Flow<PagingData<TvPreviewModel>> =
        tvRepository.getTvAiringToday()

    override fun getTvOnTheAir(): Flow<PagingData<TvPreviewModel>> = tvRepository.getTvOnTheAir()

    override fun getTvPopular(): Flow<PagingData<TvPreviewModel>> = tvRepository.getTvPopular()

    override fun getTvTopRated(): Flow<PagingData<TvPreviewModel>> = tvRepository.getTvTopRated()

    override fun getTvDetail(id: Long): Flow<Result<TvDetailModel>> = tvRepository.getTvDetail(id)
}