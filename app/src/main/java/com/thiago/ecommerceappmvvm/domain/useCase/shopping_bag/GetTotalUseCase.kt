package com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag

import com.thiago.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class GetTotalUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke() = repository.getTotal()
}