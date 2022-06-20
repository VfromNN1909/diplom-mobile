package me.vlasoff.afa.domain.models

data class SpecialityX(
    val cost: Int,
    val degree: String,
    val examResultsForFreePlaces: Int,
    val examResultsForPaidPlaces: Int,
    val exams: List<String>,
    val freePlaces: Int,
    val paidPlaces: Int,
    val studyingForms: List<String>,
    val title: String
)