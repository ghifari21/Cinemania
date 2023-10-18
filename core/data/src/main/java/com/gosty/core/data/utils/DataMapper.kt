package com.gosty.core.data.utils

import com.gosty.core.data.api.responses.movie.MoviePreviewResponse
import com.gosty.core.domain.models.movie.MoviePreviewModel

object DataMapper {
    fun MoviePreviewResponse.toMoviePreviewModel(): MoviePreviewModel =
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
}