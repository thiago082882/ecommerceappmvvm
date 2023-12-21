package com.thiago.ecommerceappmvvm.domain.useCase.categories

import com.thiago.ecommerceappmvvm.domain.repository.CategoriesRepository

class GetCategoriesUseCase(private  val repository: CategoriesRepository){

    suspend operator fun invoke() = repository.getCategories()
}