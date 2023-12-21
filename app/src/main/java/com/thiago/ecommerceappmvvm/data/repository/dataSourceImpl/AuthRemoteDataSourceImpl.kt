package com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl

import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.data.service.AuthService
import com.thiago.ecommerceappmvvm.domain.model.AuthResponse
import com.thiago.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {

    override suspend fun login(email:String,password:String)= authService.login(email,password)
    override suspend fun register(user: User): Response<AuthResponse> =authService.register(user)
}