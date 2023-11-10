package com.gosty.response.common

import com.google.gson.annotations.SerializedName

data class DateResponse(
    @field:SerializedName("maximum")
    val maximum: String? = null,

    @field:SerializedName("minimum")
    val minimum: String? = null
)
