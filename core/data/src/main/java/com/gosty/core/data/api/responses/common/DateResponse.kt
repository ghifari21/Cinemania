package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class DateResponse(
    @field:SerializedName("maximum")
    val maximum: String,

    @field:SerializedName("minimum")
    val minimum: String
)
