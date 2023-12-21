package com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl

import com.thiago.ecommerceappmvvm.data.datastore.AuthDatastore
import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.thiago.ecommerceappmvvm.domain.model.AuthResponse
import com.thiago.ecommerceappmvvm.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDatastore) :AuthLocalDataSource{
    override suspend fun saveSession(authResponse: AuthResponse)= authDataStore.save(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)
    override suspend fun logout() = authDataStore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}