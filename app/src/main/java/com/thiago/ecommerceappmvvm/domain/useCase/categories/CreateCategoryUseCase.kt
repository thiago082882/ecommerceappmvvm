package com.thiago.ecommerceappmvvm.domain.useCase.categories

import com.thiago.ecommerceappmvvm.domain.models.Category
import com.thiago.ecommerceappmvvm.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase(private  val repository: CategoriesRepository){

    suspend operator fun invoke(category: Category,file: File) = repository.create(category,file)
}