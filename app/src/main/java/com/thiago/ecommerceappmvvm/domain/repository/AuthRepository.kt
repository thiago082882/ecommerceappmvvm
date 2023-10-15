package com.thiago.ecommerceappmvvm.domain.repository

import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.domain.util.Response

interface AuthRepository{

    suspend fun login(email:String,password:String): Response<User>



}