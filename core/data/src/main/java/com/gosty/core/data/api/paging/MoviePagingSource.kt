package com.gosty.core.data.api.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.gosty.core.data.api.responses.movie.MoviePreviewResponse
import com.gosty.core.data.api.services.MovieService
import com.gosty.core.data.utils.ResponseErrorException
import com.gosty.core.data.utils.ServicePaging

class MoviePagingSource(
    private val movieService: MovieService,
    private val crashlytics: FirebaseCrashlytics,
    private val type: ServicePaging
) : PagingSource<Int, MoviePreviewResponse>() {
    override fun getRefreshKey(state: PagingState<Int, MoviePreviewResponse>): Int? =
        state.anchorPosition?.let { pos ->
            val anchorPage = state.closestPageToPosition(pos)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviePreviewResponse> =
        try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val response = when (type) {
                ServicePaging.NOW_PLAYING -> movieService.getMovieNowPlaying(position)

                ServicePaging.POPULAR -> movieService.getMoviePopular(position)

                ServicePaging.TOP_RATED -> movieService.getMovieTopRated(position)

                ServicePaging.UPCOMING -> movieService.getMovieUpcoming(position)
            }

            if (response.isSuccessful) {
                val responseData = response.body()

                LoadResult.Page(
                    data = responseData!!.results,
                    prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                    nextKey = if (position == responseData.totalPages) null else position + 1
                )
            } else {
                LoadResult.Error(ResponseErrorException("Code ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            crashlytics.log(e.message.toString())
            LoadResult.Error(e)
        }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}