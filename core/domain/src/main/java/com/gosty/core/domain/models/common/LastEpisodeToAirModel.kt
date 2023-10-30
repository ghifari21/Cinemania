package com.gosty.core.domain.models.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LastEpisodeToAirModel(
    val id: Long? = null,
    val name: String? = null,
    val overview: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Long? = null,
    val airDate: String? = null,
    val episodeNumber: Int? = null,
    val episodeType: String? = null,
    val productionCode: String? = null,
    val runtime: Int? = null,
    val seasonNumber: Int? = null,
    val showId: Long? = null,
    val stillPath: String? = null
) : Parcelable