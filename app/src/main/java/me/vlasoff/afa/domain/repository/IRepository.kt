package me.vlasoff.afa.domain.repository

import com.google.firebase.auth.AuthResult
import me.vlasoff.afa.data.network.apiservice.ResultWrapper
import me.vlasoff.afa.domain.models.UniversitiesResponse

interface IRepository {
    interface INetWorkRepository {
        suspend fun getUniversities(): ResultWrapper<UniversitiesResponse>
    }
    interface IAuthRepository {
        suspend fun signIn(email: String, password: String): AuthResult
        suspend fun signUp(email: String, password: String): AuthResult
    }
}