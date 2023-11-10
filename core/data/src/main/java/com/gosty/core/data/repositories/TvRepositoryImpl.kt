package com.gosty.core.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.gosty.common.utils.DataMapper.map
import com.gosty.common.utils.DataMapper.toModel
import com.gosty.common.utils.Result
import com.gosty.core.data.api.ApiDataSource
import com.gosty.model.tv.TvDetailModel
import com.gosty.model.tv.TvPreviewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource,
//    private val firebaseDataSource: FirebaseDataSource
) : TvRepository {
    override fun getTvAiringToday(): Flow<PagingData<TvPreviewModel>> =
        Pager(
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

    override fun getTvOnTheAir(): Flow<PagingData<TvPreviewModel>> =
        Pager(
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

    override fun getTvPopular(): Flow<PagingData<TvPreviewModel>> =
        Pager(
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

    override fun getTvTopRated(): Flow<PagingData<TvPreviewModel>> =
        Pager(
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

    override fun getTvDetail(id: Long): Flow<Result<TvDetailModel>> =
        apiDataSource.getTvDetail(id).map { result ->
            result.map { response ->
                response.toModel()
            }
        }

    override fun getTvAiringTodayHighlight(): Flow<Result<List<TvPreviewModel>>> =
        apiDataSource.getTvAiringTodayHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }

    override fun getTvOnTheAirHighlight(): Flow<Result<List<TvPreviewModel>>> =
        apiDataSource.getTvOnTheAirHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }

    override fun getTvPopularHighlight(): Flow<Result<List<TvPreviewModel>>> =
        apiDataSource.getTvPopularHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }

    override fun getTvTopRatedHighlight(): Flow<Result<List<TvPreviewModel>>> =
        apiDataSource.getTvTopRatedHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }
}