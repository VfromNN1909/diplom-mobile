package me.vlasoff.afa.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import me.vlasoff.afa.data.repositories.UniversitiesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Singleton
    @Provides
    fun providesRealmInstance() =
        Realm.getDefaultInstance()

    @Provides
    fun providesUniversitiesRepository(realm: Realm, @ApplicationContext context: Context) =
        UniversitiesRepository(realm, context)
}