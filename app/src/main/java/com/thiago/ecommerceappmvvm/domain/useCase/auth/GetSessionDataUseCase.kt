package com.thiago.ecommerceappmvvm.domain.useCase.auth

import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository

class GetSessionDataUseCase  constructor( private val repository: AuthRepository){

    operator fun invoke() = repository.getSessionData()
}