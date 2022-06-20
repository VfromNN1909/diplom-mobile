package me.vlasoff.afa.domain.models

import io.realm.RealmObject

open class Info(
    var address: String = "",
    var cite: String = "",
    var description: String = "",
    var email: String = "",
    var fullName: String = "",
    var hasDormitory: Boolean = false,
    var hasFreePlaces: Boolean = false,
    var hasLicence: Boolean = false,
    var hasMilitaryDepartment: Boolean = false,
    var isGovernmental: Boolean = false,
    var phoneNumber: String = ""
): RealmObject()