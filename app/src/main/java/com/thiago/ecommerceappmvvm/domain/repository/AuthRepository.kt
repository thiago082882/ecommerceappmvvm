package com.thiago.ecommerceappmvvm.domain.repository

import com.thiago.ecommerceappmvvm.domain.models.AuthResponse
import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository{

    suspend fun login(email:String,password:String): Resource<AuthResponse>
    suspend fun register(user : User): Resource<AuthResponse>

    suspend fun  saveSession(authResponse : AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>



}