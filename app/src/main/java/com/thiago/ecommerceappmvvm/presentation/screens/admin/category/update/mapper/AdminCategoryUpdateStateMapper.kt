package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.update.mapper


import com.thiago.ecommerceappmvvm.domain.model.Category
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.update.AdminCategoryUpdateState

fun AdminCategoryUpdateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}