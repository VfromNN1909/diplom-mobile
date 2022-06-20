package me.vlasoff.afa.domain.models

data class Content(
    val city: String,
    val cost: Int,
    val examResultsForFreePlaces: Int,
    val examResultsForPaidPlaces: Int,
    val freePlaces: Int,
    val id: Id,
    val info: Info,
    val infoLink: String,
    val logoUrl: String,
    val paidPlaces: Int,
    val programs: List<ProgramX>,
    val specialities: List<SpecialityX>,
    val specialitiesShortDescription: String,
    val title: String
)