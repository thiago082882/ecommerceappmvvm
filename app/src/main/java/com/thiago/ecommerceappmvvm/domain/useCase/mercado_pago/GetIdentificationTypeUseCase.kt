package com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago

import com.thiago.ecommerceappmvvm.domain.repository.MercadoPagoRepository


class GetIdentificationTypeUseCase(private val repository: MercadoPagoRepository) {

    operator fun invoke() = repository.getIdentificationTypes()

}