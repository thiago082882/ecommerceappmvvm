package com.thiago.ecommerceappmvvm.domain.useCase.orders

import com.thiago.ecommerceappmvvm.domain.repository.OrdersRepository

class FindAllOrdersUseCase(private val  repository: OrdersRepository) {
operator  fun invoke() = repository.findAll()
}