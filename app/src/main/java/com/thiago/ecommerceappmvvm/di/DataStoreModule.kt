package com.thiago.ecommerceappmvvm.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.thiago.ecommerceappmvvm.core.Config.AUTH_PREFERENCE
import com.thiago.ecommerceappmvvm.data.dataSource.local.dao.ProductsDao
import com.thiago.ecommerceappmvvm.data.dataSource.local.datastore.AuthDatastore
import com.thiago.ecommerceappmvvm.data.dataSource.local.db.EcommerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providerPreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(AUTH_PREFERENCE)
            }
        )

    @Provides
    @Singleton
    fun  providerAuthDataStore(dataStore:DataStore<Preferences>) = AuthDatastore(dataStore)

}