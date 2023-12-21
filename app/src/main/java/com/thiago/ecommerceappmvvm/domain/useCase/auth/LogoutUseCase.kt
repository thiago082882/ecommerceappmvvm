package com.thiago.ecommerceappmvvm.domain.useCase.auth

import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository){

    suspend operator fun invoke() = repository.logout()

    }
