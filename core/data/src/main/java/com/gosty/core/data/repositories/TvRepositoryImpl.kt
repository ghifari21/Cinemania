package com.gosty.core.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.gosty.core.data.api.ApiDataSource
import com.gosty.core.data.firebase.FirebaseDataSource
import com.gosty.core.data.utils.DataMapper.toModel
import com.gosty.core.data.utils.Result
import com.gosty.core.data.utils.map
import com.gosty.core.domain.models.tv.TvDetailModel
import com.gosty.core.domain.models.tv.TvPreviewModel
import com.gosty.core.domain.repositories.TvRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource,
    private val firebaseDataSource: FirebaseDataSource
) : TvRepository {
    override fun getTvAiringToday(): Flow<PagingData<TvPreviewModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getTvAiringToday()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }
    }

    override fun getTvOnTheAir(): Flow<PagingData<TvPreviewModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getTvOnTheAir()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }
    }

    override fun getTvPopular(): Flow<PagingData<TvPreviewModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getTvPopular()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }
    }

    override fun getTvTopRated(): Flow<PagingData<TvPreviewModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getTvTopRated()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }
    }

    override fun getTvDetail(id: Long): Flow<Result<TvDetailModel>> =
        apiDataSource.getTvDetail(id).map { result ->
            result.map { response ->
                response.toModel()
            }
        }
}