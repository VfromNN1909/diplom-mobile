package me.vlasoff.afa.data.network.apiservice

import me.vlasoff.afa.domain.models.UniversitiesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("universities")
    suspend fun getUniversities(): UniversitiesResponse
}