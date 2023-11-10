package com.gosty.response.movie

import com.google.gson.annotations.SerializedName
import com.gosty.response.common.CollectionResponse
import com.gosty.response.common.GenreResponse
import com.gosty.response.common.LanguageResponse
import com.gosty.response.common.ProductionCompanyResponse
import com.gosty.response.common.ProductionCountryResponse

data class MovieDetailResponse(
    @field:SerializedName("adult")
    val isAdult: Boolean? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("belongs_to_collection")
    val belongsToCollection: CollectionResponse? = null,

    @field:SerializedName("budget")
    val budget: Long? = null,

    @field:SerializedName("genres")
    val genres: List<GenreResponse>? = null,

    @field:SerializedName("homepage")
    val homepage: String? = null,

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("imdb_id")
    val imdbId: String? = null,

    @field:SerializedName("original_language")
    val originalLanguage: String? = null,

    @field:SerializedName("original_title")
    val originalTitle: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("popularity")
    val popularity: Double? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyResponse>? = null,

    @field:SerializedName("production_countries")
    val productionCountries: List<ProductionCountryResponse>? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("revenue")
    val revenue: Long? = null,

    @field:SerializedName("runtime")
    val runtime: Int? = null,

    @field:SerializedName("spoken_languages")
    val spokenLanguages: List<LanguageResponse>? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("tagline")
    val tagline: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("video")
    val video: Boolean? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("vote_count")
    val voteCount: Long? = null
)
