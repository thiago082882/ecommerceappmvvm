package com.thiago.ecommerceappmvvm.domain.useCase.address

import com.thiago.ecommerceappmvvm.domain.repository.AddressRepository

class FindByUserAddressUseCase(private val repository: AddressRepository) {

    suspend operator fun invoke(idUser: String) = repository.findByUser(idUser)

}