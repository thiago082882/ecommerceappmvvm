package com.thiago.ecommerceappmvvm.data.service

import com.thiago.ecommerceappmvvm.domain.model.AuthResponse
import com.thiago.ecommerceappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    //http://10.0.0.134/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Body() user: User,
    ): Response<AuthResponse>
}