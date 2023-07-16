package com.thiago.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")
        private set

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

    fun validateForm() = viewModelScope.launch {
        if (state.name == "") {
            errorMessage = "Insira um  nome"
        } else if (state.lastname == "") {
            errorMessage = "Insira um  Sobrenome"
        } else if (state.email == "") {
            errorMessage = "Insira um  Email"
        } else if (state.phone == "") {
            errorMessage = "Insira um  Telefone"
        } else if (state.password == "") {
            errorMessage = "Insira uma senha"
        } else if (state.confirmPassword == "") {
            errorMessage = "Insira uma senha de confirmação"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "O email não é valido"
        } else if (state.password.length < 6) {
            errorMessage = "A senha deverá conter pelo menos 6 caracteres"
        } else if (state.password != state.confirmPassword) {
            errorMessage = "As senha não coincidem"
        }

        delay(3000)

        errorMessage = ""

    }

}