package com.thiago.ecommerceappmvvm.presentation.screens.auth.login


import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set


//
//    var email by mutableStateOf("")
//    var password by mutableStateOf("")


    var errorMessage by mutableStateOf("")
        private set

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun validateForm() = viewModelScope.launch {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "O email não é valido"
        } else if (state.password.length < 6) {
            errorMessage = "A senha deverá conter pelo menos 6 caracteres"
        }

        delay(3000)

        errorMessage = ""

    }

}