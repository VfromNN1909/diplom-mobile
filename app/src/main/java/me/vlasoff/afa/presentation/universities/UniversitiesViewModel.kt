package me.vlasoff.afa.presentation.universities

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.vlasoff.afa.data.repositories.UniversitiesRepository
import me.vlasoff.afa.domain.usecases.GetAllUniversitiesUseCase
import javax.inject.Inject

@HiltViewModel
class UniversitiesViewModel @Inject constructor(
    private val getAllUniversitiesUseCase: GetAllUniversitiesUseCase,
    private val repository: UniversitiesRepository
) : ViewModel() {

//    fun getData() = getAllUniversitiesUseCase.execute().map { pagingData ->
//        pagingData.map { movieFromNetwork ->
//            Log.d("paging", movieFromNetwork.toString())
//            movieFromNetwork
//        }
//    }.cachedIn(viewModelScope)

    fun getData() =
        repository.getAllDataFlow()

    fun writeData() {
        repository.fillDatabase()
    }

    fun logHello() {
        Log.d("universities", "hello")
    }
}