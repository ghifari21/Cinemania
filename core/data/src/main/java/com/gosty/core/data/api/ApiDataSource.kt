package com.gosty.core.data.api

import androidx.paging.PagingSource
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.gosty.common.utils.Result
import com.gosty.core.data.api.paging.MoviePagingSource
import com.gosty.core.data.api.paging.TvPagingSource
import com.gosty.core.data.api.services.MovieService
import com.gosty.core.data.api.services.TvService
import com.gosty.core.data.utils.MovieServicePaging
import com.gosty.core.data.utils.TvServicePaging
import com.gosty.response.movie.MovieDetailResponse
import com.gosty.response.movie.MoviePreviewResponse
import com.gosty.response.tv.TvDetailResponse
import com.gosty.response.tv.TvPreviewResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiDataSource @Inject constructor(
    private val movieService: MovieService,
    private val tvService: TvService,
    private val crashlytics: FirebaseCrashlytics
) {
    // Movies
    fun getMovieNowPlaying(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.NOW_PLAYING
        )
    }

    fun getMoviePopular(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.POPULAR
        )
    }

    fun getMovieTopRated(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.TOP_RATED
        )
    }

    fun getMovieUpcoming(): PagingSource<Int, MoviePreviewResponse> {
        return MoviePagingSource(
            movieService = movieService,
            crashlytics = crashlytics,
            type = MovieServicePaging.UPCOMING
        )
    }

    fun getMovieDetail(id: Long): Flow<Result<MovieDetailResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = movieService.getMovieDetail(id)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    emit(Result.Success(response.body()!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getMovieNowPlayingHighlight(): Flow<Result<List<MoviePreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = movieService.getMovieNowPlaying(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getMoviePopularHighlight(): Flow<Result<List<MoviePreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = movieService.getMoviePopular(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getMovieTopRatedHighlight(): Flow<Result<List<MoviePreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = movieService.getMovieTopRated(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getMovieUpcomingHighlight(): Flow<Result<List<MoviePreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = movieService.getMovieUpcoming(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // Tvs
    fun getTvAiringToday(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.AIRING_TODAY
        )
    }

    fun getTvOnTheAir(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.ON_THE_AIR
        )
    }

    fun getTvPopular(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.POPULAR
        )
    }

    fun getTvTopRated(): PagingSource<Int, TvPreviewResponse> {
        return TvPagingSource(
            tvService = tvService,
            crashlytics = crashlytics,
            type = TvServicePaging.TOP_RATED
        )
    }

    fun getTvDetail(id: Long): Flow<Result<TvDetailResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = tvService.getTvDetail(id)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    emit(Result.Success(response.body()!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getTvAiringTodayHighlight(): Flow<Result<List<TvPreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = tvService.getTvAiringToday(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getTvOnTheAirHighlight(): Flow<Result<List<TvPreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = tvService.getTvOnTheAir(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getTvPopularHighlight(): Flow<Result<List<TvPreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = tvService.getTvPopular(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun getTvTopRatedHighlight(): Flow<Result<List<TvPreviewResponse>>> = flow {
        emit(Result.Loading)
        try {
            val response = tvService.getTvTopRated(1)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val data = response.body()?.results?.take(10)
                    emit(Result.Success(data!!))
                } else {
                    emit(Result.Empty)
                }
            } else {
                emit(Result.Error("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}