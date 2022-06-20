package me.vlasoff.afa.domain.models

import io.realm.RealmList
import io.realm.RealmObject

open class University(
    var title: String = "", //
    var specialitiesShortDescription: String = "",
    var city: String = "", //
    var logoUrl: String = "", //
    var cost: Int? = null, //
    var examResultsForFreePlaces: Int? = null,//
    var freePlaces: Int? = null,//
    var examResultsForPaidPlaces: Int? = null,//
    var paidPlaces: Int? = null,//
    var infoLink: String = "", //
    var info: UniversityInfo? = null,
    var specialities: RealmList<Speciality> = RealmList(),
    var programs: RealmList<Program> = RealmList(),
    var professions: RealmList<String> = RealmList(),
): RealmObject()