package com.thiago.ecommerceappmvvm.presentation.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCase: AuthUseCase):ViewModel() {

    fun getSessionData()= viewModelScope.launch {

    }
fun logout() = viewModelScope.launch {
    authUseCase.logout
}
}