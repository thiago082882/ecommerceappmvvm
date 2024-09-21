package com.thiago.ecommerceappmvvm.domain.useCase.orders

data class OrdersUseCases(
    val findAllOrdersUseCase: FindAllOrdersUseCase,
    val findByClientOrdersUseCase: FindByClientOrdersUseCase,
    val updateStatusOrdersUseCase: UpdateStatusOrdersUseCase
)
