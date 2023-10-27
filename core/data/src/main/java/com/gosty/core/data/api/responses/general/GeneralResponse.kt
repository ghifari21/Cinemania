package com.gosty.core.data.api.responses.general

import com.google.gson.annotations.SerializedName
import com.gosty.core.data.api.responses.common.DateResponse

data class GeneralResponse<T>(
    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("results")
    val results: List<T>? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null,

    @field:SerializedName("dates")
    val dates: DateResponse? = null,
)
