package com.gosty.core.domain.models.movie

import android.os.Parcelable
import com.gosty.core.domain.models.common.CollectionModel
import com.gosty.core.domain.models.common.GenreModel
import com.gosty.core.domain.models.common.LanguageModel
import com.gosty.core.domain.models.common.ProductionCompanyModel
import com.gosty.core.domain.models.common.ProductionCountryModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailModel(
    val isAdult: Boolean? = null,
    val backdropPath: String? = null,
    val belongsToCollection: CollectionModel? = null,
    val budget: Long? = null,
    val genres: List<GenreModel>? = null,
    val homepage: String? = null,
    val id: Long? = null,
    val imdbId: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val productionCompanies: List<ProductionCompanyModel>? = null,
    val productionCountries: List<ProductionCountryModel>? = null,
    val releaseDate: String? = null,
    val revenue: Long? = null,
    val runtime: Int? = null,
    val spokenLanguages: List<LanguageModel>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = null,
    val voteCount: Long? = null
) : Parcelable
