package com.gosty.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gosty.common.components.ErrorState
import com.gosty.common.components.LoadingState
import com.gosty.common.utils.Result
import com.gosty.home.R
import com.gosty.home.components.HomeSection
import com.gosty.home.components.MovieCardRow
import com.gosty.home.components.TvCardRow

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val nowPlayingMovie by viewModel.nowPlayingMovies.collectAsState()
    val popularMovies by viewModel.popularMovies.collectAsState()
    val topRatedMovies by viewModel.topRatedMovies.collectAsState()
    val upcomingMovies by viewModel.upcomingMovies.collectAsState()
    val nowPlayingTv by viewModel.nowPlayingTv.collectAsState()
    val onTheAirTv by viewModel.onTheAirTv.collectAsState()
    val popularTv by viewModel.popularTv.collectAsState()
    val topRatedTv by viewModel.topRatedTv.collectAsState()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        /***
         * now playing movies
         */
        HomeSection(
            title = stringResource(id = R.string.now_playing_movie),
            onMoreClick = { /*TODO*/ },
            content = {
                when (nowPlayingMovie) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        MovieCardRow(list = (nowPlayingMovie as Result.Success).data)
                    }
                }
            }
        )

        /***
         * airing today series
         */
        HomeSection(
            title = stringResource(id = R.string.airing_today_series),
            onMoreClick = { /*TODO*/ },
            content = {
                when (nowPlayingTv) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        TvCardRow(list = (nowPlayingTv as Result.Success).data)
                    }
                }
            }
        )

        /***
         * on the air series
         */
        HomeSection(
            title = stringResource(id = R.string.on_the_air_series),
            onMoreClick = { /*TODO*/ },
            content = {
                when (onTheAirTv) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        TvCardRow(list = (onTheAirTv as Result.Success).data)
                    }
                }
            }
        )

        /***
         * popular movies
         */
        HomeSection(
            title = stringResource(id = R.string.popular_movies),
            onMoreClick = { /*TODO*/ },
            content = {
                when (popularMovies) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        MovieCardRow(list = (popularMovies as Result.Success).data)
                    }
                }
            }
        )

        /***
         * popular series
         */
        HomeSection(
            title = stringResource(id = R.string.popular_series),
            onMoreClick = { /*TODO*/ },
            content = {
                when (popularTv) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        TvCardRow(list = (popularTv as Result.Success).data)
                    }
                }
            }
        )

        /***
         * top rated movies
         */
        HomeSection(
            title = stringResource(id = R.string.top_rated_movies),
            onMoreClick = { /*TODO*/ },
            content = {
                when (topRatedMovies) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        MovieCardRow(list = (topRatedMovies as Result.Success).data)
                    }
                }
            }
        )

        /***
         * top rated series
         */
        HomeSection(
            title = stringResource(id = R.string.top_rated_series),
            onMoreClick = { /*TODO*/ },
            content = {
                when (topRatedTv) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        TvCardRow(list = (topRatedTv as Result.Success).data)
                    }
                }
            }
        )

        /***
         * upcoming movies
         */
        HomeSection(
            title = stringResource(id = R.string.upcoming_movies),
            onMoreClick = { /*TODO*/ },
            content = {
                when (upcomingMovies) {
                    is Result.Empty -> {}
                    is Result.Error -> {
                        ErrorState {
                            viewModel.getData()
                        }
                    }

                    is Result.Loading -> {
                        LoadingState()
                    }

                    is Result.Success -> {
                        MovieCardRow(list = (upcomingMovies as Result.Success).data)
                    }
                }
            }
        )
    }
}