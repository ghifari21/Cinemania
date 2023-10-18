package com.gosty.core.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.gosty.core.data.api.ApiDataSource
import com.gosty.core.data.firebase.FirebaseDataSource
import com.gosty.core.data.utils.DataMapper.toMoviePreviewModel
import com.gosty.core.domain.models.movie.MoviePreviewModel
import com.gosty.core.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource,
    private val firebaseDataSource: FirebaseDataSource
) : MovieRepository {
    override fun getMovieNowPlaying(): Flow<PagingData<MoviePreviewModel>> {
        return Pager(
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
                    response.toMoviePreviewModel()
                }
            }
    }

    override fun getMoviePopular(): Flow<PagingData<MoviePreviewModel>> {
        return Pager(
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
                    response.toMoviePreviewModel()
                }
            }
    }

    override fun getMovieTopRated(): Flow<PagingData<MoviePreviewModel>> {
        return Pager(
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
                    response.toMoviePreviewModel()
                }
            }
    }

    override fun getMovieUpcoming(): Flow<PagingData<MoviePreviewModel>> {
        return Pager(
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
                    response.toMoviePreviewModel()
                }
            }
    }
}