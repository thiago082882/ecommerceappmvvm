package com.thiago.ecommerceappmvvm.domain.useCase.auth

import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository

class RegisterUseCase (private  val repository: AuthRepository) {

    suspend operator fun invoke(user: User)=repository.register(user)
}