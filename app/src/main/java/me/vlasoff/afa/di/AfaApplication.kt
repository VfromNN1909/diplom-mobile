package me.vlasoff.afa.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration

@HiltAndroidApp
class AfaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        RealmConfiguration.Builder()
            .schemaVersion(1L)
            .allowWritesOnUiThread(true)
            .build()
    }
}