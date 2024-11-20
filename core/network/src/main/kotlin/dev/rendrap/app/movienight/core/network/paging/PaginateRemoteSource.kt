package dev.rendrap.app.movienight.core.network.paging

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.rendrap.app.movienight.core.common.utils.Constants.ONE
import dev.rendrap.app.movienight.core.network.model.ApiResponse
import kotlinx.io.IOException

private const val STARTING_PAGE_INDEX = 1

abstract class PaginateRemoteSource<T: Any>: PagingSource<Int, T>() {

    protected abstract suspend fun fetch(page: Int, size: Int): ApiResponse<List<T>>

    override fun getRefreshKey(state: PagingState<Int, T>): Int? =
        state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(ONE)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(ONE)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val page = params.key ?: STARTING_PAGE_INDEX
            val response = fetch(page, PAGE_SIZE)

            if (response is ApiResponse.Success) {
                LoadResult.Page(
                    data = response.data,
                    prevKey = if (page == STARTING_PAGE_INDEX) null else page - ONE,
                    nextKey = if (response.data.isEmpty()) null else page + ONE
                )
            } else {
                LoadResult.Error(Exception("Something went wrong"))
            }
        } catch (ex: IOException) {
            LoadResult.Error(ex)
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

}