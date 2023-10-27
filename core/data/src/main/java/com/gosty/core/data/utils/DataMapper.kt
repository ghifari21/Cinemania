package com.gosty.core.data.utils

import com.gosty.core.data.api.responses.movie.MoviePreviewResponse
import com.gosty.core.data.api.responses.tv.TvPreviewResponse
import com.gosty.core.domain.models.movie.MoviePreviewModel
import com.gosty.core.domain.models.tv.TvPreviewModel

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
}