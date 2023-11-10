package com.gosty.core.data.api.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.gosty.core.data.api.services.TvService
import com.gosty.core.data.utils.ResponseErrorException
import com.gosty.core.data.utils.TvServicePaging
import com.gosty.response.tv.TvPreviewResponse

class TvPagingSource(
    private val tvService: TvService,
    private val crashlytics: FirebaseCrashlytics,
    private val type: TvServicePaging
) : PagingSource<Int, TvPreviewResponse>() {
    override fun getRefreshKey(state: PagingState<Int, TvPreviewResponse>): Int? =
        state.anchorPosition?.let { pos ->
            val anchorPage = state.closestPageToPosition(pos)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvPreviewResponse> =
        try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val response = when (type) {
                TvServicePaging.AIRING_TODAY -> tvService.getTvAiringToday(position)
                TvServicePaging.ON_THE_AIR -> tvService.getTvOnTheAir(position)
                TvServicePaging.POPULAR -> tvService.getTvPopular(position)
                TvServicePaging.TOP_RATED -> tvService.getTvTopRated(position)
            }

            if (response.isSuccessful) {
                val responseData = response.body()

                LoadResult.Page(
                    data = responseData?.results ?: emptyList(),
                    prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                    nextKey = if (position == responseData?.totalPages) null else position + 1
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