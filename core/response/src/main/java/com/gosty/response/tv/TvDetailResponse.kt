package com.gosty.response.tv

import com.google.gson.annotations.SerializedName
import com.gosty.response.SpokenLanguageResponse
import com.gosty.response.common.GenreResponse
import com.gosty.response.common.LastEpisodeToAirResponse
import com.gosty.response.common.NetworkResponse
import com.gosty.response.common.ProducerResponse
import com.gosty.response.common.ProductionCompanyResponse
import com.gosty.response.common.ProductionCountryResponse
import com.gosty.response.common.SeasonResponse

data class TvDetailResponse(
    @field:SerializedName("adult")
    val isAdult: Boolean? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("created_by")
    val createdBy: List<ProducerResponse>? = null,

    @field:SerializedName("episode_run_time")
    val episodeRunTime: List<Int>? = null,

    @field:SerializedName("first_air_date")
    val firstAirDate: String? = null,

    @field:SerializedName("genres")
    val genres: List<GenreResponse>? = null,

    @field:SerializedName("homepage")
    val homepage: String,

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("in_production")
    val inProduction: Boolean? = null,

    @field:SerializedName("languages")
    val languages: List<String>? = null,

    @field:SerializedName("last_air_date")
    val lastAirDate: String? = null,

    @field:SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAirResponse? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("next_episode_to_air")
    val nextAirEpisodeToAir: String? = null,

    @field:SerializedName("networks")
    val networks: List<NetworkResponse>? = null,

    @field:SerializedName("number_of_episodes")
    val numberOfEpisodes: Int? = null,

    @field:SerializedName("number_of_seasons")
    val numberOfSeasons: Int? = null,

    @field:SerializedName("origin_country")
    val originCountry: List<String>? = null,

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

    @field:SerializedName("seasons")
    val seasons: List<SeasonResponse>? = null,

    @field:SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageResponse>? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("tagline")
    val tagline: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("vote_count")
    val voteCount: Long? = null
)
