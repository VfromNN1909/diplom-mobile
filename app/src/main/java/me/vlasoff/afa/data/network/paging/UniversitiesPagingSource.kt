package me.vlasoff.afa.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.vlasoff.afa.data.network.apiservice.ResultWrapper
import me.vlasoff.afa.data.repositories.NetworkRepository
import me.vlasoff.afa.domain.models.Result
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UniversitiesPagingSource @Inject constructor(
    private val repository: NetworkRepository
) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val response = repository.getUniversities().let { response ->
                when (response) {
                    is ResultWrapper.Success -> {
                        response.value.universities
                    }
                    else -> null
                }
            }
            LoadResult.Page(
                // надо было как-то обернуть, наверное, но пусть будет, если упадет сразу будет понятно в чем дело
                data = response!!,
                prevKey = null,
                // вот в этом была проблема
                nextKey = params.key?.plus(1)
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}