package me.vlasoff.afa.presentation.calculator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CalculatorOptions(
    val rusLang: Int,
    val math: Int,
    val firstOther: Pair<String, Int>,
    val secondOther: Pair<String, Int>,
): Parcelable
