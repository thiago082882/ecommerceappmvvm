package com.thiago.ecommerceappmvvm.data.repository.dataSource

import com.thiago.ecommerceappmvvm.domain.models.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email:String,password:String):Response<User>
}