package dev.rendrap.app.movienight.core.network.utils

import androidx.paging.PagingConfig

internal object NetworkConfig {
    const val CONNECT_TIMEOUT_MILLIS = 60_000L
    const val READ_TIMEOUT_MILLIS = 60_000L
    const val WRITE_TIMEOUT_MILLIS = 60_000L
    const val REQUEST_TIMEOUT_MILLIS = 60_000L
    const val SOCKET_TIMEOUT_MILLIS = 60_000L
    const val MAX_CHUCKER_CONTENT_LENGTH = 25_000L
}

internal object CommonPagingConfig {
    private const val PREFETCH_DISTANCE = 1
    private const val PAGE_SIZE = 10

    val pagingConfig = PagingConfig(
        pageSize = PAGE_SIZE,
        initialLoadSize = PAGE_SIZE,
        prefetchDistance = PREFETCH_DISTANCE
    )
}