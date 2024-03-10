package com.thiago.ecommerceappmvvm.domain.useCase.products

import com.thiago.ecommerceappmvvm.domain.repository.ProductsRepository

class FindByNameUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(name: String) = repository.findByName(name)
}