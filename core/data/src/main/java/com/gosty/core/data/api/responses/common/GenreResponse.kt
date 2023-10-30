package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("name")
    val name: String? = null
)
