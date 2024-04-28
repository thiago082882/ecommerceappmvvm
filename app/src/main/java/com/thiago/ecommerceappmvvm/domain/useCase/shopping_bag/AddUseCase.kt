package com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag

import com.thiago.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.thiago.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class AddUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(shoppingBagProduct: ShoppingBagProduct) {
        repository.add(shoppingBagProduct)
    }
}