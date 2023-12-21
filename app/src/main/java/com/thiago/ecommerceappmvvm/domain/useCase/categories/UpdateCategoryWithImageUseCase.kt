package com.thiago.ecommerceappmvvm.domain.useCase.categories


import com.thiago.ecommerceappmvvm.domain.model.Category
import com.thiago.ecommerceappmvvm.domain.repository.CategoriesRepository
import java.io.File

class UpdateCategoryWithImageUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String, category: Category, file: File) = repository.updateWithImage(id, category, file)
}