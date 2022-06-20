package me.vlasoff.afa.domain.usecases

import me.vlasoff.afa.data.network.paging.UniversitiesRemoteDataSource
import javax.inject.Inject

class GetAllUniversitiesUseCase @Inject constructor(
    private val dataSource: UniversitiesRemoteDataSource
) {
    fun execute() = dataSource.getData()
}