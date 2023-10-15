package com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl

import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.data.service.AuthService

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {

    override suspend fun login(email:String,password:String)= authService.login(email,password)
}