package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class SeasonResponse(
    @field:SerializedName("air_date")
    val airDate: String? = null,

    @field:SerializedName("episode_count")
    val episodeCount: Int? = null,

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("season_number")
    val seasonNumber: Int? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null
)
