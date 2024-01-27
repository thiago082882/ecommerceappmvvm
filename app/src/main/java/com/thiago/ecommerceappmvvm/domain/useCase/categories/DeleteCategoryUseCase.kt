package com.thiago.ecommerceappmvvm.domain.useCase.categories


import com.thiago.ecommerceappmvvm.domain.repository.CategoriesRepository
import java.io.File

class DeleteCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}