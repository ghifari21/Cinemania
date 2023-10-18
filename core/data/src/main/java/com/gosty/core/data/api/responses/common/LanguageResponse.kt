package com.gosty.core.data.api.responses.common

import com.google.gson.annotations.SerializedName

data class LanguageResponse(
    @field:SerializedName("english_name")
    val englishName: String,

    @field:SerializedName("iso_639_1")
    val isoCode: String,

    @field:SerializedName("name")
    val name: String
)
