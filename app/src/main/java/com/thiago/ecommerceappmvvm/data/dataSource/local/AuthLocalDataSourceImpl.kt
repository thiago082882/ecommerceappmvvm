package com.thiago.ecommerceappmvvm.data.dataSource.local

import com.thiago.ecommerceappmvvm.data.dataSource.local.datastore.AuthDatastore
import com.thiago.ecommerceappmvvm.domain.model.AuthResponse
import com.thiago.ecommerceappmvvm.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDatastore) :
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse)= authDataStore.save(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)
    override suspend fun logout() = authDataStore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}