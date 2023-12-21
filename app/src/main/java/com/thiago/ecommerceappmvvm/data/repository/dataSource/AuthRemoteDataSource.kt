package com.thiago.ecommerceappmvvm.data.repository.dataSource

import com.thiago.ecommerceappmvvm.domain.model.AuthResponse
import com.thiago.ecommerceappmvvm.domain.model.User

import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email:String,password:String):Response<AuthResponse>

    suspend fun register(user: User):Response<AuthResponse>
}