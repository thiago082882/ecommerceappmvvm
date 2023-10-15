package com.thiago.ecommerceappmvvm.domain.useCase.auth

import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository

class LoginUseCase(private  val repository: AuthRepository) {

    //Chama classe diretamente para executar a função de login
    suspend operator fun invoke(email:String,password:String)=repository.login(email, password)
}