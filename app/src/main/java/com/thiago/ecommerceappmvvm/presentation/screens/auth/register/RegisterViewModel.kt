package com.thiago.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.models.AuthResponse
import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.thiago.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val  authUseCase: AuthUseCase) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }


    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun register() = viewModelScope.launch {
        if(isValidForm()) {
            val user = User(
                name = state.name,
                lastname = state.lastname,
                phone = state.phone,
                email = state.email,
                password = state.password
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result // DATA / ERROR
        }
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastname: String) {
        state = state.copy(lastname = lastname)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun isValidForm(): Boolean {
        if (state.name == "") {
            errorMessage = "Insira um  nome"
            return false
        } else if (state.lastname == "") {
            errorMessage = "Insira um  Sobrenome"
            return false
        } else if (state.email == "") {
            errorMessage = "Insira um  Email"
            return false
        } else if (state.phone == "") {
            errorMessage = "Insira um  Telefone"
            return false
        } else if (state.password == "") {
            errorMessage = "Insira uma senha"
            return false
        } else if (state.confirmPassword == "") {
            errorMessage = "Insira uma senha de confirmação"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "O email não é valido"
            return false
        } else if (state.password.length < 6) {
            errorMessage = "A senha deverá conter pelo menos 6 caracteres"
            return false
        } else if (state.password != state.confirmPassword) {
            errorMessage = "As senha não coincidem"
            return false
        }

        return true


    }

}