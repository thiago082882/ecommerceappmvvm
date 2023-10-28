package com.thiago.ecommerceappmvvm.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.thiago.ecommerceappmvvm.core.Config.AUTH_KEY
import com.thiago.ecommerceappmvvm.domain.models.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDataStore  constructor(private val dataStore:DataStore<Preferences>){

    suspend fun saveUser(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref->

            pref[dataStoreKey] = authResponse.toJson()
        }
    }

   fun  getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null) {
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            }else{
                AuthResponse()
            }
        }
    }
}