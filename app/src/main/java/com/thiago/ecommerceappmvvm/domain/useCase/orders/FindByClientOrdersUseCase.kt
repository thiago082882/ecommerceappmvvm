package com.thiago.ecommerceappmvvm.domain.useCase.orders

import com.thiago.ecommerceappmvvm.domain.repository.OrdersRepository

class FindByClientOrdersUseCase(private val  repository: OrdersRepository) {
operator  fun invoke(idClient:String) = repository.findByClient(idClient)
}