package me.vlasoff.afa.data.network.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import me.vlasoff.afa.data.repositories.NetworkRepository
import javax.inject.Inject

class UniversitiesRemoteDataSource @Inject constructor(
    private val repository: NetworkRepository
) {
    fun getData() =
        Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            pagingSourceFactory = {
                UniversitiesPagingSource(repository = repository)
            }
        ).flow
}