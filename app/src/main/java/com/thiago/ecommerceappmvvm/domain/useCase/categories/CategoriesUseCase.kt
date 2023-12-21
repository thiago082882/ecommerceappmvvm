package com.thiago.ecommerceappmvvm.domain.useCase.categories

data class CategoriesUseCase(
    val createCategory: CreateCategoryUseCase,
    val getCategoriesUseCase: GetCategoriesUseCase,
    val updateCategory: UpdateCategoryUseCase,
    val updateCategoryWithImage: UpdateCategoryWithImageUseCase
)
