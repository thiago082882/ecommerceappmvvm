package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.MercadoPagoUseCase
import com.thiago.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsFormViewModel @Inject constructor(
    private val mercadoPagoUseCase: MercadoPagoUseCase
):ViewModel(){

    var state by  mutableStateOf(ClientPaymentsFormState())
        private set
    var identificationTypeResponse by mutableStateOf<Resource<List<IdentificationType>>?>(null)
         private set


    fun getIdentificationTypes() = viewModelScope.launch {
        identificationTypeResponse = Resource.Loading
        val result = mercadoPagoUseCase.getIdentificationType().first()
        identificationTypeResponse = result
        Log.d("ClientPaymentsFormViewModel", "data:$identificationTypeResponse")
    }

    fun onCardNumberInput(input: String) {
        state = state.copy(cardNumber = input)
    }

    fun onYearExpirationInput(input: String) {
        state = state.copy(expirationYear = input)
    }

    fun onMonthExpirationInput(input: String) {
        state = state.copy(expirationMonth = input)
    }

    fun onSecurityCodeInput(input: String) {
        state = state.copy(securityCode = input)
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onIdentificationTypeInput(input: String) {
        state = state.copy(type = input)
    }

    fun onIdentificationNumberInput(input: String) {
        state = state.copy(number = input)
    }




}