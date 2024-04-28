package com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag

import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.AddUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.DeleteUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.FindAllShoppingBagUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.FindByIdShoppingBagUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.GetTotalUseCase

data class ShoppingBagUseCase(
    val add: AddUseCase,
    val delete: DeleteUseCase,
    val findAll: FindAllShoppingBagUseCase,
    val findById: FindByIdShoppingBagUseCase,
    val getTotal: GetTotalUseCase
)
