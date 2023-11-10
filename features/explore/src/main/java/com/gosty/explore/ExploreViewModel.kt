package com.gosty.explore

import androidx.lifecycle.ViewModel
import com.gosty.core.domain.usecases.MovieUseCase
import com.gosty.core.domain.usecases.TvUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase,
    private val tvUseCase: TvUseCase
) : ViewModel()