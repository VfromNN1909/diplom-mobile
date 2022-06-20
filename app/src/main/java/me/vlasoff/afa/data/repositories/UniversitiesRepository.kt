package me.vlasoff.afa.data.repositories

import android.content.Context
import android.util.Log
import io.realm.Realm
import io.realm.internal.IOException
import io.realm.kotlin.where
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import me.vlasoff.afa.R
import me.vlasoff.afa.domain.models.Speciality
import me.vlasoff.afa.domain.models.University
import me.vlasoff.afa.util.list
import javax.inject.Inject

class UniversitiesRepository @Inject constructor(
    private val realm: Realm,
    private val context: Context,
) {
    fun fillDatabase() {
        val isNotEmpty = realm.where(University::class.java).findAll().isEmpty()
        Log.d("universities", "Is not empty: $isNotEmpty")
        if (isNotEmpty) {
            realm.executeTransactionAsync { realm ->
                val is1 = context.resources.openRawResource(R.raw.data31)
                val is2 = context.resources.openRawResource(R.raw.data32)
                val is3 = context.resources.openRawResource(R.raw.data33)
                try {
                    realm.createAllFromJson(University::class.java, is1)
                    realm.createAllFromJson(University::class.java, is2)
                    realm.createAllFromJson(University::class.java, is3)
                } catch (e: IOException) {
                    if (realm.isInTransaction) realm.cancelTransaction()
                }
            }
        }
    }

    fun getAllDataFlow(): Flow<List<University>> {
        val list = realm.where(University::class.java).findAll().list()
        return flowOf(list)
    }

    fun getAllSpecialities(): List<Speciality> {
        val res = mutableListOf<Speciality>()
        realm.where(University::class.java).findAll().list().forEach {
            res.addAll(it.specialities)
        }
        return res
    }


    fun getUniversityByTitle(title: String): University? {
        return realm.where(University::class.java).equalTo("title", title).findFirst()
    }
}