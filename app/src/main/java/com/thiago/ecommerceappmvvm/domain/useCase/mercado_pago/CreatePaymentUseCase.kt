package com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago

import com.thiago.ecommerceappmvvm.domain.model.PaymentBody
import com.thiago.ecommerceappmvvm.domain.repository.MercadoPagoRepository


class CreatePaymentUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(idempotencyKey: String, paymentBody: PaymentBody) =
        repository.createPayment(idempotencyKey, paymentBody)
}
