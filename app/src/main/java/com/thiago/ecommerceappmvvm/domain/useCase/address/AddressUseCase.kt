package com.thiago.ecommerceappmvvm.domain.useCase.address

import com.thiago.ecommerceappmvvm.domain.useCase.address.CreateAddressUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.address.FindByUserAddressUseCase

data class AddressUseCase(
    val createAddress: CreateAddressUseCase,
    val findByUserAddress: FindByUserAddressUseCase,
)
