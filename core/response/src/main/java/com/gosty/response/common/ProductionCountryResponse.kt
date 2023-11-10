package com.gosty.response.common

import com.google.gson.annotations.SerializedName

data class ProductionCountryResponse(
    @field:SerializedName("iso_3166_1")
    val isoCode: String? = null,

    @field:SerializedName("name")
    val name: String? = null
)
