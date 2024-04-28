package com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag

import com.thiago.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class FindAllShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    operator fun invoke() = repository.findAll()
}