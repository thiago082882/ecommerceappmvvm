package com.thiago.ecommerceappmvvm.domain.useCase.address

import com.thiago.ecommerceappmvvm.domain.model.Address
import com.thiago.ecommerceappmvvm.domain.repository.AddressRepository

class CreateAddressUseCase(private val repository: AddressRepository) {

    suspend operator fun invoke(address: Address) = repository.create(address)

}