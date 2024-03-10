package com.thiago.ecommerceappmvvm.domain.useCase.products

import com.thiago.ecommerceappmvvm.domain.repository.ProductsRepository

class FindByCategoryUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(idCategory: String) = repository.findByCategory(idCategory)
}