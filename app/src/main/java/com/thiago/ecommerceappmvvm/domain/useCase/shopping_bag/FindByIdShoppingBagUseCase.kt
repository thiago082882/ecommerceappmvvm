package com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag

import com.thiago.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class FindByIdShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) = repository.findById(id)
}