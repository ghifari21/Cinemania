package com.gosty.core.domain.interactors

import androidx.paging.PagingData
import com.gosty.common.utils.Result
import com.gosty.core.data.repositories.MovieRepository
import com.gosty.core.domain.usecases.MovieUseCase
import com.gosty.model.movie.MovieDetailModel
import com.gosty.model.movie.MoviePreviewModel
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

    override fun getMovieNowPlayingHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        movieRepository.getMovieNowPlayingHighlight()

    override fun getMoviePopularHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        movieRepository.getMoviePopularHighlight()

    override fun getMovieTopRatedHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        movieRepository.getMovieTopRatedHighlight()

    override fun getMovieUpcomingHighlight(): Flow<Result<List<MoviePreviewModel>>> =
        movieRepository.getMovieUpcomingHighlight()
}