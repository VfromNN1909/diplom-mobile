package me.vlasoff.afa.domain.models

data class ProgramX(
    val cost: Int,
    val examResultsForFreePlaces: Int,
    val examResultsForPaidPlaces: Int,
    val exams: List<String>,
    val freePlaces: Int,
    val paidPlaces: Int,
    val title: String
)