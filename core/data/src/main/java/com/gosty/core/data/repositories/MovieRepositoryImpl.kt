package com.gosty.core.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.gosty.common.utils.DataMapper.map
import com.gosty.common.utils.DataMapper.toModel
import com.gosty.common.utils.Result
import com.gosty.core.data.api.ApiDataSource
import com.gosty.model.movie.MovieDetailModel
import com.gosty.model.movie.MoviePreviewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource,
//    private val firebaseDataSource: FirebaseDataSource
) : MovieRepository {
    override fun getMovieNowPlaying(): Flow<PagingData<MoviePreviewModel>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getMovieNowPlaying()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }

    override fun getMoviePopular(): Flow<PagingData<MoviePreviewModel>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getMoviePopular()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }

    override fun getMovieTopRated(): Flow<PagingData<MoviePreviewModel>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getMovieTopRated()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }


    override fun getMovieUpcoming(): Flow<PagingData<MoviePreviewModel>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                apiDataSource.getMovieUpcoming()
            }
        ).flow
            .map { data ->
                data.map { response ->
                    response.toModel()
                }
            }

    override fun getMovieDetail(id: Long): Flow<Result<MovieDetailModel>> =
        apiDataSource.getMovieDetail(id).map { result ->
            result.map { response ->
                response.toModel()
            }
        }

    override fun getMovieNowPlayingHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        apiDataSource.getMovieNowPlayingHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }

    override fun getMoviePopularHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        apiDataSource.getMoviePopularHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }

    override fun getMovieTopRatedHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        apiDataSource.getMovieTopRatedHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }

    override fun getMovieUpcomingHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        apiDataSource.getMovieUpcomingHighlight().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }
}