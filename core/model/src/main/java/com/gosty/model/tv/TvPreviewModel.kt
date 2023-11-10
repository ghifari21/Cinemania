package com.gosty.model.tv

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvPreviewModel(
    val backdropPath: String? = null,
    val firstAirDate: String? = null,
    val genreIds: List<Long>? = null,
    val id: Long? = null,
    val name: String? = null,
    val originCountry: List<String>? = null,
    val originalLanguage: String? = null,
    val originalName: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Long? = null
) : Parcelable
