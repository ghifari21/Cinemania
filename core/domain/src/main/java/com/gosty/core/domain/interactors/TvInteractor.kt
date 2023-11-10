package com.gosty.core.domain.interactors

import androidx.paging.PagingData
import com.gosty.common.utils.Result
import com.gosty.core.data.repositories.TvRepository
import com.gosty.core.domain.usecases.TvUseCase
import com.gosty.model.tv.TvDetailModel
import com.gosty.model.tv.TvPreviewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvInteractor @Inject constructor(
    private val tvRepository: TvRepository
) : TvUseCase {
    override fun getTvAiringToday(): Flow<PagingData<TvPreviewModel>> =
        tvRepository.getTvAiringToday()

    override fun getTvOnTheAir(): Flow<PagingData<TvPreviewModel>> =
        tvRepository.getTvOnTheAir()

    override fun getTvPopular(): Flow<PagingData<TvPreviewModel>> =
        tvRepository.getTvPopular()

    override fun getTvTopRated(): Flow<PagingData<TvPreviewModel>> =
        tvRepository.getTvTopRated()

    override fun getTvDetail(id: Long): Flow<Result<TvDetailModel>> =
        tvRepository.getTvDetail(id)

    override fun getTvAiringTodayHighlight(): Flow<Result<List<TvPreviewModel>>> =
        tvRepository.getTvAiringTodayHighlight()

    override fun getTvOnTheAirHighlight(): Flow<Result<List<TvPreviewModel>>> =
        tvRepository.getTvOnTheAirHighlight()

    override fun getTvPopularHighlight(): Flow<Result<List<TvPreviewModel>>> =
        tvRepository.getTvPopularHighlight()

    override fun getTvTopRatedHighlight(): Flow<Result<List<TvPreviewModel>>> =
        tvRepository.getTvTopRatedHighlight()
}