package com.thiago.ecommerceappmvvm.domain.useCase.products

import com.thiago.ecommerceappmvvm.domain.model.Product
import com.thiago.ecommerceappmvvm.domain.repository.ProductsRepository

class UpdateProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product) = repository.update(id, product)
}