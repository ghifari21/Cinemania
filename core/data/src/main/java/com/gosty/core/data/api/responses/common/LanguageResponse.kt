package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class LanguageResponse(
    @field:SerializedName("english_name")
    val englishName: String? = null,

    @field:SerializedName("iso_639_1")
    val isoCode: String? = null,

    @field:SerializedName("name")
    val name: String? = null
)
