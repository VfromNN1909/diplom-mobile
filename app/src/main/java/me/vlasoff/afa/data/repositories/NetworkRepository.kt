package me.vlasoff.afa.data.repositories

import android.util.Log
import me.vlasoff.afa.data.network.apiservice.ApiService
import me.vlasoff.afa.data.network.apiservice.ResultWrapper
import me.vlasoff.afa.data.network.apiservice.safeApiCall
import me.vlasoff.afa.domain.models.UniversitiesResponse
import me.vlasoff.afa.domain.repository.IRepository
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val apiService: ApiService
) : IRepository.INetWorkRepository {
    override suspend fun getUniversities(): ResultWrapper<UniversitiesResponse> {
        return safeApiCall {
            val data = apiService.getUniversities()
            Log.d("universities", data.toString())
            data
        }
    }
}