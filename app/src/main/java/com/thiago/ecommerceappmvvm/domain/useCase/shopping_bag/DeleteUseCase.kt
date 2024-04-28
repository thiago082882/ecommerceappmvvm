package com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag

import com.thiago.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class DeleteUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) {
        repository.delete(id)
    }
}