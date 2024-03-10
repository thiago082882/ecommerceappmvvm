package com.thiago.ecommerceappmvvm.domain.useCase.products

import com.thiago.ecommerceappmvvm.domain.repository.ProductsRepository

class FindAllUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke() = repository.findAll()
}