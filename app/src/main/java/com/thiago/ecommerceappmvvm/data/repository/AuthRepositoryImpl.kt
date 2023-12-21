package com.thiago.ecommerceappmvvm.data.repository

import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.domain.model.AuthResponse
import com.thiago.ecommerceappmvvm.domain.model.User
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.login(email, password)
        )


    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(

        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)
    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout()=authLocalDataSource.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}