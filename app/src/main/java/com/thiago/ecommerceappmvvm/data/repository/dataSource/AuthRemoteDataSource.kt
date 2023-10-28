package com.thiago.ecommerceappmvvm.data.repository.dataSource

import com.thiago.ecommerceappmvvm.domain.models.AuthResponse
import com.thiago.ecommerceappmvvm.domain.models.User

import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email:String,password:String):Response<AuthResponse>

    suspend fun register(user: User):Response<AuthResponse>
}