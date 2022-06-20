package me.vlasoff.afa.presentation.calculator

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.vlasoff.afa.data.repositories.UniversitiesRepository
import me.vlasoff.afa.domain.models.Speciality
import me.vlasoff.afa.util.calculateExamsSum
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val repository: UniversitiesRepository
) : ViewModel() {

    fun findSpecialities(options: CalculatorOptions): List<Speciality> {
        val specialities = repository.getAllSpecialities()
        return specialities.filter { speciality ->
            val examResults = speciality.examResultsForFreePlaces ?: 0
            val exams = speciality.exams.toList().map { it.lowercase().trim() }
            examResults <= options.calculateExamsSum() &&
                    exams.contains(options.firstOther.first.lowercase()) ||
                    exams.contains(options.secondOther.first.lowercase())
        }
    }

    fun buildCalculatorOptions(
        rus: String,
        math: String,
        third: Pair<String, String>,
        fourth: Pair<String, String>
    ): CalculatorOptions {
        return CalculatorOptions(
            rus.toInt(),
            math.toInt(),
            Pair(third.first, third.second.toInt()),
            Pair(fourth.first, fourth.second.toInt())
        )
    }
}