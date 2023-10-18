package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class ProductionCountryResponse(
    @field:SerializedName("iso_3166_1")
    val isoCode: String,

    @field:SerializedName("name")
    val name: String
)
