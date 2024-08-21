package com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago

import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.CreateCardTokenUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.CreatePaymentUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.GetIdentificationTypeUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.GetInstallmentsUseCase

data class MercadoPagoUseCase(
    val getIdentificationType: GetIdentificationTypeUseCase,
    val getInstallments: GetInstallmentsUseCase,
    val createCardToken: CreateCardTokenUseCase,
    val createPayment: CreatePaymentUseCase,

)
