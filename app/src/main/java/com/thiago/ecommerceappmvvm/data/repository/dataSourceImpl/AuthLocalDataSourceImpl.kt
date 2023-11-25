package com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl

import com.thiago.ecommerceappmvvm.data.datastore.AuthDataStore
import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.thiago.ecommerceappmvvm.domain.models.AuthResponse
import com.thiago.ecommerceappmvvm.domain.models.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore) :AuthLocalDataSource{
    override suspend fun saveSession(authResponse: AuthResponse)= authDataStore.saveUser(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)
    override suspend fun logout() = authDataStore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}