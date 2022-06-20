package me.vlasoff.afa.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vlasoff.afa.data.network.apiservice.ApiService
import me.vlasoff.afa.data.network.apiservice.Interceptor
import me.vlasoff.afa.data.network.paging.UniversitiesRemoteDataSource
import me.vlasoff.afa.data.repositories.AuthRepository
import me.vlasoff.afa.data.repositories.NetworkRepository
import me.vlasoff.afa.domain.usecases.GetAllUniversitiesUseCase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = "http://10.0.2.2:8080/api/v2/univer/"

    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(Interceptor())
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl: String, client: OkHttpClient) =
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

    @Provides
    fun providesMoviesApiService(retrofit: Retrofit) =
        retrofit.create(ApiService::class.java)

    @Provides
    fun providesNetworkRepository(apiService: ApiService) =
        NetworkRepository(apiService)


    @Provides
    fun providesUniversitiesRemoteDataSource(repository: NetworkRepository) =
        UniversitiesRemoteDataSource(repository)

    @Provides
    fun providesGetAllUniversitiesUseCase(dataSource: UniversitiesRemoteDataSource) =
        GetAllUniversitiesUseCase(dataSource)

    @Provides
    fun provideAuthRepository() = AuthRepository()
}