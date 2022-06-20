package me.vlasoff.afa.domain.models

import io.realm.RealmObject

open class UniversityInfo(
    var fullName: String = "",
    var hasDormitory: Boolean = false,
    var isGovernmental: Boolean = false,
    var hasMilitaryDepartment: Boolean = false,
    var hasFreePlaces: Boolean = false,
    var hasLicence: Boolean = false,
    var description: String = "",
    var phoneNumber: String = "",
    var address: String = "",
    var email: String = "",
    var cite: String = "",
) : RealmObject()
