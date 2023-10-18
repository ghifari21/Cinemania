package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class CollectionResponse(
    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String
)
