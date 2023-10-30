package com.gosty.core.domain.interactors

import androidx.paging.PagingData
import com.gosty.core.data.utils.Result
import com.gosty.core.domain.models.movie.MovieDetailModel
import com.gosty.core.domain.models.movie.MoviePreviewModel
import com.gosty.core.domain.repositories.MovieRepository
import com.gosty.core.domain.usecases.MovieUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(
    private val movieRepository: MovieRepository
) : MovieUseCase {
    override fun getMovieNowPlaying(): Flow<PagingData<MoviePreviewModel>> =
        movieRepository.getMovieNowPlaying()

    override fun getMoviePopular(): Flow<PagingData<MoviePreviewModel>> =
        movieRepository.getMoviePopular()

    override fun getMovieTopRated(): Flow<PagingData<MoviePreviewModel>> =
        movieRepository.getMovieTopRated()

    override fun getMovieUpcoming(): Flow<PagingData<MoviePreviewModel>> =
        movieRepository.getMovieUpcoming()

    override fun getMovieDetail(id: Long): Flow<Result<MovieDetailModel>> =
        movieRepository.getMovieDetail(id)
}