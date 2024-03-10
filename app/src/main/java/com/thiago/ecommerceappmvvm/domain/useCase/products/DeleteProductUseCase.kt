package com.thiago.ecommerceappmvvm.domain.useCase.products

import com.thiago.ecommerceappmvvm.domain.repository.ProductsRepository

class DeleteProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}