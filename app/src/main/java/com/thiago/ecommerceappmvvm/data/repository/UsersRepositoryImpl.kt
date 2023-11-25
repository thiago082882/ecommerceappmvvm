package com.thiago.ecommerceappmvvm.data.repository

import com.thiago.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.domain.repository.UsersRepository
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.domain.util.ResponseToRequest
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
): UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File) = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )

}