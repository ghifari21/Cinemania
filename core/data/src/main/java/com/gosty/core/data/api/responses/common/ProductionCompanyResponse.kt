package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class ProductionCompanyResponse(
    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("logo_path")
    val logoPath: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("origin_country")
    val originCountry: String? = null
)
