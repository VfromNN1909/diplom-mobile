package me.vlasoff.afa.domain.models

import io.realm.RealmList
import io.realm.RealmObject

open class Speciality(
    var title: String = "",
    var degree: String = "",
    var studyingForms: RealmList<String> = RealmList(),
    var exams: RealmList<String> = RealmList(),
    var cost: Int? = null,
    var examResultsForFreePlaces: Int? = null,
    var freePlaces: Int? = null,
    var examResultsForPaidPlaces: Int? = null,
    var paidPlaces: Int? = null,
): RealmObject()
