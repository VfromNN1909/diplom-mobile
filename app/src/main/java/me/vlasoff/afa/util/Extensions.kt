package me.vlasoff.afa.util

import io.realm.RealmObject
import io.realm.RealmResults
import me.vlasoff.afa.domain.models.University
import me.vlasoff.afa.presentation.calculator.CalculatorOptions

fun RealmResults<University>.list(): List<University> {
    val res = mutableListOf<University>()
    this.forEach { university ->
        res.add(university)
    }
    return res
}

fun CalculatorOptions.calculateExamsSum(): Int {
    return this.rusLang + this.math + this.firstOther.second + this.secondOther.second
}