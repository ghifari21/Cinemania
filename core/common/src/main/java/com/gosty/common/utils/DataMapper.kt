package com.gosty.common.utils

import com.gosty.model.common.CollectionModel
import com.gosty.model.common.GenreModel
import com.gosty.model.common.LanguageModel
import com.gosty.model.common.LastEpisodeToAirModel
import com.gosty.model.common.NetworkModel
import com.gosty.model.common.ProducerModel
import com.gosty.model.common.ProductionCompanyModel
import com.gosty.model.common.ProductionCountryModel
import com.gosty.model.common.SeasonModel
import com.gosty.model.common.SpokenLanguageModel
import com.gosty.model.movie.MovieDetailModel
import com.gosty.model.movie.MoviePreviewModel
import com.gosty.model.tv.TvDetailModel
import com.gosty.model.tv.TvPreviewModel
import com.gosty.response.SpokenLanguageResponse
import com.gosty.response.common.CollectionResponse
import com.gosty.response.common.GenreResponse
import com.gosty.response.common.LanguageResponse
import com.gosty.response.common.LastEpisodeToAirResponse
import com.gosty.response.common.NetworkResponse
import com.gosty.response.common.ProducerResponse
import com.gosty.response.common.ProductionCompanyResponse
import com.gosty.response.common.ProductionCountryResponse
import com.gosty.response.common.SeasonResponse
import com.gosty.response.movie.MovieDetailResponse
import com.gosty.response.movie.MoviePreviewResponse
import com.gosty.response.tv.TvDetailResponse
import com.gosty.response.tv.TvPreviewResponse

object DataMapper {
    fun MoviePreviewResponse.toModel(): MoviePreviewModel =
        MoviePreviewModel(
            isAdult = this.isAdult,
            backdropPath = this.backdropPath,
            genreIds = this.genreIds,
            id = this.id,
            originalLanguage = this.originalLanguage,
            originalTitle = this.originalTitle,
            overview = this.overview,
            popularity = this.popularity,
            posterPath = this.posterPath,
            releaseDate = this.releaseDate,
            title = this.title,
            isVideo = this.isVideo,
            voteAverage = this.voteAverage,
            voteCount = this.voteCount
        )

    fun MovieDetailResponse.toModel(): MovieDetailModel =
        MovieDetailModel(
            isAdult = this.isAdult,
            backdropPath = this.backdropPath,
            belongsToCollection = this.belongsToCollection?.toModel(),
            budget = this.budget,
            genres = this.genres?.map { response ->
                response.toModel()
            },
            homepage = this.homepage,
            id = this.id,
            imdbId = this.imdbId,
            originalLanguage = this.originalLanguage,
            originalTitle = this.originalTitle,
            overview = this.overview,
            popularity = this.popularity,
            posterPath = this.posterPath,
            productionCompanies = this.productionCompanies?.map { response ->
                response.toModel()
            },
            productionCountries = this.productionCountries?.map { response ->
                response.toModel()
            },
            releaseDate = this.releaseDate,
            revenue = this.revenue,
            runtime = this.runtime,
            spokenLanguages = this.spokenLanguages?.map { response ->
                response.toModel()
            },
            status = this.status,
            tagline = this.tagline,
            title = this.title,
            video = this.video,
            voteAverage = this.voteAverage,
            voteCount = this.voteCount
        )

    fun TvPreviewResponse.toModel(): TvPreviewModel =
        TvPreviewModel(
            backdropPath = this.backdropPath,
            firstAirDate = this.firstAirDate,
            genreIds = this.genreIds,
            id = this.id,
            name = this.name,
            originCountry = this.originCountry,
            originalLanguage = this.originalLanguage,
            originalName = this.originalName,
            overview = this.overview,
            popularity = this.popularity,
            posterPath = this.posterPath,
            voteAverage = this.voteAverage,
            voteCount = this.voteCount
        )

    fun TvDetailResponse.toModel(): TvDetailModel =
        TvDetailModel(
            isAdult = this.isAdult,
            backdropPath = this.backdropPath,
            createdBy = this.createdBy?.map { response ->
                response.toModel()
            },
            episodeRunTime = this.episodeRunTime,
            firstAirDate = this.firstAirDate,
            genres = this.genres?.map { response ->
                response.toModel()
            },
            homepage = this.homepage,
            id = this.id,
            inProduction = this.inProduction,
            languages = this.languages,
            lastAirDate = this.lastAirDate,
            lastEpisodeToAir = this.lastEpisodeToAir?.toModel(),
            name = this.name,
            nextAirEpisodeToAir = this.nextAirEpisodeToAir,
            networks = this.networks?.map { response ->
                response.toModel()
            },
            numberOfEpisodes = this.numberOfEpisodes,
            numberOfSeasons = this.numberOfSeasons,
            originCountry = this.originCountry,
            originalLanguage = this.originalLanguage,
            originalTitle = this.originalTitle,
            overview = this.overview,
            popularity = this.popularity,
            posterPath = this.posterPath,
            productionCompanies = this.productionCompanies?.map { response ->
                response.toModel()
            },
            productionCountries = this.productionCountries?.map { response ->
                response.toModel()
            },
            seasons = this.seasons?.map { response ->
                response.toModel()
            },
            spokenLanguages = this.spokenLanguages?.map { response ->
                response.toModel()
            },
            status = this.status,
            tagline = this.tagline,
            type = this.type,
            voteAverage = this.voteAverage,
            voteCount = this.voteCount
        )

    fun CollectionResponse.toModel(): CollectionModel =
        CollectionModel(
            id = this.id,
            name = this.name,
            posterPath = this.posterPath,
            backdropPath = this.backdropPath
        )

    fun GenreResponse.toModel(): GenreModel =
        GenreModel(
            id = this.id,
            name = this.name
        )

    fun ProductionCompanyResponse.toModel(): ProductionCompanyModel =
        ProductionCompanyModel(
            id = this.id,
            logoPath = this.logoPath,
            name = this.name,
            originCountry = this.originCountry
        )

    fun ProductionCountryResponse.toModel(): ProductionCountryModel =
        ProductionCountryModel(
            isoCode = this.isoCode,
            name = this.name
        )

    fun LanguageResponse.toModel(): LanguageModel =
        LanguageModel(
            englishName = this.englishName,
            isoCode = this.isoCode,
            name = this.name
        )

    fun ProducerResponse.toModel(): ProducerModel =
        ProducerModel(
            id = this.id,
            creditId = this.creditId,
            name = this.name,
            gender = this.gender,
            profilePath = this.profilePath
        )

    fun LastEpisodeToAirResponse.toModel(): LastEpisodeToAirModel =
        LastEpisodeToAirModel(
            id = this.id,
            name = this.name,
            overview = this.overview,
            voteAverage = this.voteAverage,
            voteCount = this.voteCount,
            airDate = this.airDate,
            episodeNumber = this.episodeNumber,
            episodeType = this.episodeType,
            productionCode = this.productionCode,
            runtime = this.runtime,
            seasonNumber = this.seasonNumber,
            showId = this.showId,
            stillPath = this.stillPath
        )

    fun NetworkResponse.toModel(): NetworkModel =
        NetworkModel(
            id = this.id,
            logoPath = this.logoPath,
            name = this.name,
            originCountry = this.originCountry
        )

    fun SeasonResponse.toModel(): SeasonModel =
        SeasonModel(
            airDate = this.airDate,
            episodeCount = this.episodeCount,
            id = this.id,
            name = this.name,
            overview = this.overview,
            posterPath = this.posterPath,
            seasonNumber = this.seasonNumber,
            voteAverage = this.voteAverage
        )

    fun SpokenLanguageResponse.toModel(): SpokenLanguageModel =
        SpokenLanguageModel(
            englishName = this.englishName,
            isoCode = this.isoCode,
            name = this.name
        )

    fun <T, U> Result<T>.map(transform: (T) -> U): Result<U> {
        return when (this) {
            is Result.Success -> Result.Success(transform(data))
            is Result.Error -> this
            is Result.Loading -> this
            is Result.Empty -> this
        }
    }
}