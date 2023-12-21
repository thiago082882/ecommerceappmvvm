package com.thiago.ecommerceappmvvm.domain.useCase.auth

import com.thiago.ecommerceappmvvm.domain.model.AuthResponse
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository

class SaveSessionUseCase constructor( private val repository: AuthRepository){

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)

    }
