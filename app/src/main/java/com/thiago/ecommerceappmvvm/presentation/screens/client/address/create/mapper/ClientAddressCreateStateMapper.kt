package com.thiago.ecommerceappmvvm.presentation.screens.client.address.create.mapper

import com.thiago.ecommerceappmvvm.domain.model.Address
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress(): Address {
    return Address(
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}