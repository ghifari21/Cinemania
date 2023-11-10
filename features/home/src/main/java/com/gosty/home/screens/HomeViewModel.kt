package com.gosty.home.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gosty.common.utils.Result
import com.gosty.core.domain.usecases.MovieUseCase
import com.gosty.core.domain.usecases.TvUseCase
import com.gosty.model.movie.MoviePreviewModel
import com.gosty.model.tv.TvPreviewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase,
    private val tvUseCase: TvUseCase
) : ViewModel() {
    private val _nowPlayingMovies: MutableStateFlow<Result<List<MoviePreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val nowPlayingMovies: StateFlow<Result<List<MoviePreviewModel>>> get() = _nowPlayingMovies.asStateFlow()

    private val _popularMovies: MutableStateFlow<Result<List<MoviePreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val popularMovies: StateFlow<Result<List<MoviePreviewModel>>> get() = _popularMovies

    private val _topRatedMovies: MutableStateFlow<Result<List<MoviePreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val topRatedMovies: StateFlow<Result<List<MoviePreviewModel>>> get() = _topRatedMovies

    private val _upcomingMovies: MutableStateFlow<Result<List<MoviePreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val upcomingMovies: StateFlow<Result<List<MoviePreviewModel>>> get() = _upcomingMovies

    private val _nowPlayingTv: MutableStateFlow<Result<List<TvPreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val nowPlayingTv: StateFlow<Result<List<TvPreviewModel>>> get() = _nowPlayingTv.asStateFlow()

    private val _onTheAirTv: MutableStateFlow<Result<List<TvPreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val onTheAirTv: StateFlow<Result<List<TvPreviewModel>>> get() = _onTheAirTv

    private val _popularTv: MutableStateFlow<Result<List<TvPreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val popularTv: StateFlow<Result<List<TvPreviewModel>>> get() = _popularTv

    private val _topRatedTv: MutableStateFlow<Result<List<TvPreviewModel>>> =
        MutableStateFlow(Result.Empty)
    val topRatedTv: StateFlow<Result<List<TvPreviewModel>>> get() = _topRatedTv

    init {
        getData()
    }

    fun getData() {
        getNowPlayingMovies()
        getPopularMovies()
        getTopRatedMovies()
        getUpcomingMovies()
        getNowPlayingTv()
        getOnTheAirTv()
        getPopularTv()
        getTopRatedTv()
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch {
            movieUseCase
                .getMovieNowPlayingHighlight()
                .collectLatest { data ->
                    _nowPlayingMovies.update { data }
                }
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            movieUseCase
                .getMoviePopularHighlight()
                .collectLatest { data ->
                    _popularMovies.update { data }
                }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            movieUseCase
                .getMovieTopRatedHighlight()
                .collectLatest { data ->
                    _topRatedMovies.update { data }
                }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            movieUseCase
                .getMovieUpcomingHighlight()
                .collectLatest { data ->
                    _upcomingMovies.update { data }
                }
        }
    }

    private fun getNowPlayingTv() {
        viewModelScope.launch {
            tvUseCase
                .getTvAiringTodayHighlight()
                .collectLatest { data ->
                    _nowPlayingTv.update { data }
                }
        }
    }

    private fun getOnTheAirTv() {
        viewModelScope.launch {
            tvUseCase
                .getTvOnTheAirHighlight()
                .collectLatest { data ->
                    _onTheAirTv.update { data }
                }
        }
    }

    private fun getPopularTv() {
        viewModelScope.launch {
            tvUseCase
                .getTvPopularHighlight()
                .collectLatest { data ->
                    _popularTv.update { data }
                }
        }
    }

    private fun getTopRatedTv() {
        viewModelScope.launch {
            tvUseCase
                .getTvTopRatedHighlight()
                .collectLatest { data ->
                    _topRatedTv.update { data }
                }
        }
    }
}