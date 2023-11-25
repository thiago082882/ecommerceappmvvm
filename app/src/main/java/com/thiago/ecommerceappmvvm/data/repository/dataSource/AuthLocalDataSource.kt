package com.thiago.ecommerceappmvvm.data.repository.dataSource

import com.thiago.ecommerceappmvvm.domain.models.AuthResponse
import com.thiago.ecommerceappmvvm.domain.models.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun  saveSession(authResponse : AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun  logout()
    fun getSessionData(): Flow<AuthResponse>
}