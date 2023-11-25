package com.thiago.ecommerceappmvvm.domain.useCase.users

import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.domain.repository.UsersRepository

class UpdateUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}