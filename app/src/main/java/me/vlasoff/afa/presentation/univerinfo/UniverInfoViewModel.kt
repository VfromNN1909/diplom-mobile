package me.vlasoff.afa.presentation.univerinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.vlasoff.afa.data.repositories.UniversitiesRepository
import javax.inject.Inject

@HiltViewModel
class UniverInfoViewModel @Inject constructor(
    private val repository: UniversitiesRepository
) : ViewModel() {

    val currentUniverTitle = MutableLiveData<String>()

    fun getDataByTitle(title: String) = repository.getUniversityByTitle(title)
}