package com.gosty.model.tv

import android.os.Parcelable
import com.gosty.model.common.GenreModel
import com.gosty.model.common.LastEpisodeToAirModel
import com.gosty.model.common.NetworkModel
import com.gosty.model.common.ProducerModel
import com.gosty.model.common.ProductionCompanyModel
import com.gosty.model.common.ProductionCountryModel
import com.gosty.model.common.SeasonModel
import com.gosty.model.common.SpokenLanguageModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvDetailModel(
    val isAdult: Boolean? = null,
    val backdropPath: String? = null,
    val createdBy: List<ProducerModel>? = null,
    val episodeRunTime: List<Int>? = null,
    val firstAirDate: String? = null,
    val genres: List<GenreModel>? = null,
    val homepage: String? = null,
    val id: Long? = null,
    val inProduction: Boolean? = null,
    val languages: List<String>? = null,
    val lastAirDate: String? = null,
    val lastEpisodeToAir: LastEpisodeToAirModel? = null,
    val name: String? = null,
    val nextAirEpisodeToAir: String? = null,
    val networks: List<NetworkModel>? = null,
    val numberOfEpisodes: Int? = null,
    val numberOfSeasons: Int? = null,
    val originCountry: List<String>? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val productionCompanies: List<ProductionCompanyModel>? = null,
    val productionCountries: List<ProductionCountryModel>? = null,
    val seasons: List<SeasonModel>? = null,
    val spokenLanguages: List<SpokenLanguageModel>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val type: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Long? = null
) : Parcelable
