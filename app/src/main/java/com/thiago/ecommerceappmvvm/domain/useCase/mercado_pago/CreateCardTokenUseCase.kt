package com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago

import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.repository.MercadoPagoRepository


class CreateCardTokenUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(cardTokenBody: CardTokenBody) = repository.createCardToken(cardTokenBody)

}