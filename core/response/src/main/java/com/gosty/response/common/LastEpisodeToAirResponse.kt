package com.gosty.response.common

import com.google.gson.annotations.SerializedName

data class LastEpisodeToAirResponse(
    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("vote_count")
    val voteCount: Long? = null,

    @field:SerializedName("air_date")
    val airDate: String? = null,

    @field:SerializedName("episode_number")
    val episodeNumber: Int? = null,

    @field:SerializedName("episode_type")
    val episodeType: String? = null,

    @field:SerializedName("production_code")
    val productionCode: String? = null,

    @field:SerializedName("runtime")
    val runtime: Int? = null,

    @field:SerializedName("season_number")
    val seasonNumber: Int? = null,

    @field:SerializedName("show_id")
    val showId: Long? = null,

    @field:SerializedName("still_path")
    val stillPath: String? = null
)
