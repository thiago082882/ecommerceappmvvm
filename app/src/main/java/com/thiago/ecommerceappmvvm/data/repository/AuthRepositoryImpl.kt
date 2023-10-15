package com.thiago.ecommerceappmvvm.data.repository

import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository
import com.thiago.ecommerceappmvvm.domain.util.Response

class AuthRepositoryImpl(private val authRemoteDataSource:AuthRemoteDataSource):AuthRepository {
    override suspend fun login(email: String, password: String): Response<User> {
      return  try {
          val result = authRemoteDataSource.login(email, password)
          Response.Success(result.body()!!)
      }catch (e:Exception){
          e.printStackTrace()
          Response.Failure(e)
      }
    }

}