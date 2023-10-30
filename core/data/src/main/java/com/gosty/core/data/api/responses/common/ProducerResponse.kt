package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class ProducerResponse(
    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("credit_id")
    val creditId: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("gender")
    val gender: Int? = null,

    @field:SerializedName("profile_path")
    val profilePath: String? = null
)
