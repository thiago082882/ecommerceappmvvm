package com.thiago.ecommerceappmvvm.data.mapper

import com.thiago.ecommerceappmvvm.data.dataSource.local.entity.CategoryEntity
import com.thiago.ecommerceappmvvm.domain.model.Category

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}