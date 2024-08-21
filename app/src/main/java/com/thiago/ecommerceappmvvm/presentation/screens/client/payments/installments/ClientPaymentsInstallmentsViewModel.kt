package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.model.*
import com.thiago.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.MercadoPagoUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.ShoppingBagUseCase
import com.thiago.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsInstallmentsViewModel @Inject constructor(
    private val mercadoPagoUseCase: MercadoPagoUseCase,
    private val shoppingBagUseCase: ShoppingBagUseCase,
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var data = savedStateHandle.get<String>("payment_form")
    val cardTokenBody = CardTokenBody.fromJson(data!!)

    var cardTokenResponse by mutableStateOf<Resource<CardTokenResponse>?>(null)
        private set

    var paymentResponse by mutableStateOf<Resource<PaymentResponse>?>(null)
        private set

    var installmentsResponse by mutableStateOf<Resource<Installment>?>(null)
        private set

    var installment by mutableStateOf<Installment?>(null)
        private set

    var totalToPay by mutableStateOf(0.0)
        private set

    var user by mutableStateOf<User?>(null)
        private set

    var shoppingBag = mutableStateListOf<ShoppingBagProduct>()
        private set

    var selectedInstallment by mutableStateOf<PayerCost?>(null)

    init {
        getTotalToPay()
        getSessionData()
        getShoppingBag()
    }

    fun getShoppingBag() = viewModelScope.launch {
        shoppingBag.addAll(shoppingBagUseCase.findAll().first())
    }

    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
    }

    fun getTotalToPay() = viewModelScope.launch {
        totalToPay = shoppingBagUseCase.getTotal()
    }

    fun getInstallments(firstSixDigits: Int, amount: Double) = viewModelScope.launch {
        installmentsResponse = Resource.Loading
        val result = mercadoPagoUseCase.getInstallments(firstSixDigits, amount).first()
        installmentsResponse = result
        installmentsResponse.run {
            when(this) {
                is Resource.Success -> {
                    installment = this.data
                }
                else -> {}
            }
        }
        Log.d("ClientPaymentsFormViewModel", "Data: ${installmentsResponse}")
    }

    fun createCardToken() = viewModelScope.launch {
        cardTokenResponse = Resource.Loading
        val result = mercadoPagoUseCase.createCardToken(cardTokenBody)
        cardTokenResponse = result
        Log.d("ClientPaymentsInstallmentsViewModel", "Card Token Body: ${cardTokenBody}")
        Log.d("ClientPaymentsInstallmentsViewModel", "Card Token Response: ${cardTokenResponse}")
    }

//    fun createPayment(token: String) = viewModelScope.launch {
//        val paymentBody = PaymentBody(
//            token = token,
//            installments = selectedInstallment?.installments!!,
//            issuerID = installment?.issuer?.id!!,
//            paymentMethodID = installment?.paymentMethodID!!,
//            transactionAmount = totalToPay,
//            payer = Payer(
//                email = user?.email ?: "",
//                identification = Identification(
//                    type = cardTokenBody.cardholder.identification.type,
//                    number = cardTokenBody.cardholder.identification.number
//                )
//            ),
//            order = Order(
//                idClient = user?.id ?: "",
//                idAddress = user?.address?.id ?: "",
//                products = shoppingBag.toList()
//            )
//        )
//        Log.d("ClientPaymentsInstallmentsViewModel", "Payment Body: ${paymentBody}")
//        paymentResponse = Resource.Loading
//        val result = mercadoPagoUseCase.createPayment(paymentBody)
//        paymentResponse = result
//        Log.d("", "payment Response: ${paymentResponse}")
//    }
fun createPayment(token: String) = viewModelScope.launch {
    // Gera um UUID para o idempotencyKey
    val idempotencyKey = UUID.randomUUID().toString()

    // Cria o PaymentBody
    val paymentBody = PaymentBody(
        token = token,
        installments = selectedInstallment?.installments ?: 0,
        issuerID = (installment?.issuer?.id ?: 0).toString(),
        paymentMethodID = installment?.paymentMethodID ?: "",
        transactionAmount = totalToPay,
        payer = Payer(
            email = user?.email ?: "",
            identification = Identification(
                type = cardTokenBody.cardholder.identification.type,
                number = cardTokenBody.cardholder.identification.number
            )
        ),
        order = Order(
            idClient = user?.id ?: "",
            idAddress = user?.address?.id ?: "",
            products = shoppingBag.toList()
        )
    )

    // Log do PaymentBody
    Log.d("ClientPaymentsInstallmentsViewModel", "Payment Body: $paymentBody")

    // Define o estado de carregamento
    paymentResponse = Resource.Loading

    // Faz a chamada para criar o pagamento com o idempotencyKey
    val result = mercadoPagoUseCase.createPayment(idempotencyKey, paymentBody)

    // Atualiza a resposta do pagamento
    paymentResponse = result

    // Log da resposta do pagamento
    Log.d("ClientPaymentsInstallmentsViewModel", "Payment Response: $paymentResponse")
}


}