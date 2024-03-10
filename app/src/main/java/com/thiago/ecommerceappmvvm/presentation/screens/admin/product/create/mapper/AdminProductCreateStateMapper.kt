package com.thiago.ecommerceappmvvm.presentation.screens.admin.product.create.mapper

import com.thiago.ecommerceappmvvm.domain.model.Product
import com.thiago.ecommerceappmvvm.presentation.screens.admin.product.create.AdminProductCreateState

fun AdminProductCreateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}