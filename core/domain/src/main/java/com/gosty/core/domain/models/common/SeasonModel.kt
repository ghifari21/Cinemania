package com.gosty.core.domain.models.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeasonModel(
    val airDate: String? = null,
    val episodeCount: Int? = null,
    val id: Long? = null,
    val name: String? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val seasonNumber: Int? = null,
    val voteAverage: Double? = null
) : Parcelable