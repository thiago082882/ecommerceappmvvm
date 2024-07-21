package com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago

import com.thiago.ecommerceappmvvm.domain.repository.MercadoPagoRepository


class GetInstallmentsUseCase(private val repository: MercadoPagoRepository) {

    operator fun invoke(firstSixDigits: Int, amount: Double) = repository.getInstallments(firstSixDigits, amount)

}