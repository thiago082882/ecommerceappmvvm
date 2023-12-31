package com.thiago.ecommerceappmvvm.presentation.screens.auth.login


import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.models.AuthResponse
import com.thiago.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.thiago.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set


//
//    var email by mutableStateOf("")
//    var password by mutableStateOf("")


    var errorMessage by mutableStateOf("")
//        private set

    //Login Response

     var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect(){data->
            if(!data.token.isNullOrBlank()){
                loginResponse = Resource.Success(data)
            }
        }
    }
    fun login() = viewModelScope.launch {
        if(isvalidForm()){
            loginResponse = Resource.Loading // Esperando uma resposta
            val result =authUseCase.login(state.email,state.password)//Retorna uma resposta
            loginResponse = result // Se foi sucesso ou error
            Log.d("LoginViewModel", "Response: $loginResponse")
        }


    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    private fun isvalidForm() : Boolean  {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "O email não é valido"
            return false
        } else if (state.password.length < 6) {
            errorMessage = "A senha deverá conter pelo menos 6 caracteres"
            return false
        }

        return true

    }

}