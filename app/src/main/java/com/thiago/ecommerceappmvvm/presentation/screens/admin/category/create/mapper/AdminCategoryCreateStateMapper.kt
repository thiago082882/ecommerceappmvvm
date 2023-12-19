package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.mapper


import com.thiago.ecommerceappmvvm.domain.models.Category
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}